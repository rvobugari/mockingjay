package com.npixels.mockingjay.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.npixels.mockingjay.exception.*;
import com.npixels.mockingjay.exception.FileNotFoundException;
import com.wordnik.swagger.core.*;
import org.eclipse.jetty.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.npixels.mockingjay.dto.LocationGuidanceDTO;
import com.npixels.mockingjay.transformer.GuidanceModelTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.*;
import java.net.URI;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * RESTful resource endpoint for mockingjay microservice.
 */


@Path("/mocker")
@Produces(MediaType.APPLICATION_JSON)
@Service
@Api(value = "files", description = "Endpoints for physical file management")
public class MockingjayResource {

  private static final Logger logger = LoggerFactory.getLogger(MockingjayResource.class);
  private static final String responseDir = "/Users/rvobugari/junk/GET/";
  private static final String customPathGuidanceDir = "/Users/rvobugari/junk/custom-path-dictionary/";
  private static final String PARAMS_REGEX = "\\$p_(\\w+)";
  private static final String PATH_PARAM= "\\$pathparam";
  private static final String HEADER_REGEX = "\\$h_(\\w+)";

  @Autowired
  GuidanceModelTransformer guidanceModelTransformer;



  @GET
  @Path("{path : .+}")
  @Produces(value = MediaType.APPLICATION_JSON)
//  @ApiOperation(value = "Retrieve a image by id",
//          produces = MediaType.APPLICATION_JSON)
//  @ApiResponses({
//          @ApiResponse(code = HttpStatus.NOT_FOUND_404,
//                  message = "The requested image could not be found"),
//          @ApiResponse(code = HttpStatus.BAD_REQUEST_400,
//                  message = "The request is not valid. The response body will contain a code and " +
//                          "details specifying the source of the error."),
//          @ApiResponse(code = HttpStatus.UNAUTHORIZED_401,
//                  message = "User is unauthorized to perform the desired operation")
//  })

  public Response getMethod(
          @ApiParam(name = "id", value = "id of page to retrieve image content", required = true)
          @PathParam("path") String getpath, @Context HttpServletRequest httpRequest, @Context UriInfo uriInfo) {

    //Step 0: Set defaults and getPath String.
    String contentType = "application/json";
    String method = "getMethod";
    String httpMethodType = "GET";
    String resolvedResponseBodyFile = null;
    Response.ResponseBuilder myresponseFinalBuilderObject = null;

    try {

      String paramPathStg = getpath.replace("/", ".");

      //Step 1: Get responseGuidanceObject
      //TODO: handle JsonTransformationException exception.
      LocationGuidanceDTO responseGuidanceObject = resolveResponsePaths(httpMethodType, paramPathStg);

      //Step 2: Create queryparams hash and headers hash.
      Map<String, String> queryParamsMap = grabRestParams(uriInfo);
      Map<String, String> headerMap = getHeaderMap(httpRequest);


      //Step 3: TODO: Resolve header and params variables from  Guidance JSON Body.
      resolvedResponseBodyFile = findExtractAndReplaceSubStg(responseGuidanceObject.getResponseBodyFile(), HEADER_REGEX, headerMap);
      resolvedResponseBodyFile = findExtractAndReplaceSubStg(resolvedResponseBodyFile, PARAMS_REGEX, headerMap);

      //Step 4: TODO: Validate responseBody, responseHeader, responseCode files existence and have rightJson structures.

      //Step 6: TODO: Grab responses body

      String responseJson = replaceHeadersAndParamsInJson(headerMap, queryParamsMap, resolvedResponseBodyFile);

      //Step 5: TODO: Decorate with response header
      String headerStg = "{\"ContentType\": \"$contentType\"}";

      //Step 7: TODO: Grab response code and related responsebuilderobject
      Response.ResponseBuilder myRespBuilder = returnRespBuilderObject(responseGuidanceObject.getResponseCode(), null).entity(responseJson);

      //Step 5: TODO: Decorate with response headers
      myresponseFinalBuilderObject = decorateWithResponseHeaders(myRespBuilder, responseGuidanceObject.getResponseHeaderFile());

      return myresponseFinalBuilderObject.build();
    } catch (IOException ex) {
      logger.error("api={}", "getContents", ex);
      mapAndThrow(ex);
    }
    return myresponseFinalBuilderObject.build();
  }

  private Response.ResponseBuilder decorateWithResponseHeaders(Response.ResponseBuilder myrespBuilderObject, String responseHeaderFile) throws IOException {

    Response.ResponseBuilder myTempRespBuilderObject = null;
    //If No custom headerFile then return with standard headers
    if (responseHeaderFile == null) {
      myTempRespBuilderObject = myrespBuilderObject.header("Content-type", "\"application/json\"");
    } else {
      Map<String, Object> headersHash = convertJsonIntoHashMap(responseHeaderFile);
      Iterator it = headersHash.entrySet().iterator();
      while (it.hasNext()) {
        Map.Entry pair = (Map.Entry) it.next();
        myTempRespBuilderObject = myrespBuilderObject.header(pair.getKey().toString(), pair.getValue().toString());
        it.remove();
      }

    }

    return myTempRespBuilderObject;
  }

  private Map<String, Object> convertJsonIntoHashMap(String responseHeaderFile) throws IOException {
    String json = readFileContentsIntoStg(responseHeaderFile);
    HashMap<String, Object> result = new ObjectMapper().readValue(json, HashMap.class);

    return result;
  }

  private Response.ResponseBuilder returnRespBuilderObject(String responseCode, URI createdUri) {
    if ((responseCode == null) || responseCode.contains("200") || responseCode.equalsIgnoreCase("ok")) {
      return Response.ok();
    } else if ((responseCode.contains("201") || responseCode.equalsIgnoreCase("created"))) {
      return Response.created(createdUri);
    } else {
      return Response.ok();
    }
  }

  private String replaceHeadersAndParamsInJson(Map<String, String> headerMap, Map<String, String> paramsMap, String inputJsonFile) throws IOException {
    String sCurrentLine;
    String outputJson = null;
    BufferedReader br = new BufferedReader(new FileReader(inputJsonFile));
    while ((sCurrentLine = br.readLine()) != null) {
      sCurrentLine = findExtractAndReplaceSubStg(sCurrentLine, HEADER_REGEX, headerMap);
      sCurrentLine = findExtractAndReplaceSubStg(sCurrentLine, PARAMS_REGEX, paramsMap);
      outputJson += sCurrentLine;
    }
    return outputJson;
  }

  private String readFileContentsIntoStg(String inputJsonFile) throws IOException {
    String sCurrentLine;
    String outputJson = null;
    BufferedReader br = new BufferedReader(new FileReader(inputJsonFile));
    while ((sCurrentLine = br.readLine()) != null) {
      if(outputJson != null) {
        outputJson += sCurrentLine;
      } else {
        outputJson = sCurrentLine;
      }
    }
    return outputJson;
  }

  private LocationGuidanceDTO resolveResponsePaths(String httpMethod, String pathParamStg) throws IOException {
    String responseFileLocation = null;
    LocationGuidanceDTO responseGuidanceObjectDTO = null;
    String customGuidanceJsonFile = customPathGuidanceDir + pathParamStg + "." + httpMethod + ".guide";
    File customGuidanceJsonFileObject = new File(customGuidanceJsonFile);
    //TODO: Handle an exception when the actual file is absent.
    if (customGuidanceJsonFileObject.isFile() && customGuidanceJsonFileObject.canRead()) {
      // Open the stream.
      FileInputStream in = new FileInputStream(customGuidanceJsonFileObject);
      try {
        responseGuidanceObjectDTO = guidanceModelTransformer.toGuidanceModel(customGuidanceJsonFileObject);
        if (responseGuidanceObjectDTO.getResponseBodyFile() != null) {
          responseGuidanceObjectDTO.setResponseBodyFile(responseDir + responseGuidanceObjectDTO.getResponseBodyFile().replaceAll(PATH_PARAM, pathParamStg));
        }
        if (responseGuidanceObjectDTO.getResponseHeaderFile() != null) {
          responseGuidanceObjectDTO.setResponseHeaderFile(responseDir + responseGuidanceObjectDTO.getResponseHeaderFile().replaceAll(PATH_PARAM, pathParamStg));
        }
      }
      finally {
        in.close();
      }
      //TODO: catch JSON parser exception.
    } else {
      logger.info("No custom guidance file reading from standard response file location");
      responseGuidanceObjectDTO.setResponseBodyFile(responseDir + pathParamStg + "." + httpMethod + ".response" + ".body");
      responseGuidanceObjectDTO.setResponseHeaderFile(responseDir + pathParamStg + "." + httpMethod + ".response" + ".header");
      responseGuidanceObjectDTO.setResponseCode(responseDir + pathParamStg + "." + httpMethod + ".response" + ".code");
    }
    return responseGuidanceObjectDTO;
  }

  private Map<String, String> getHeaderMap(HttpServletRequest httpRequest) {
    Map<String, String> headerMap = new HashMap<String, String>();
    Enumeration headerNames = httpRequest.getHeaderNames();

    while (headerNames.hasMoreElements()) {
      String key = (String) headerNames.nextElement();
      String value = httpRequest.getHeader(key);
      headerMap.put(key, value);
    }
    return headerMap;
  }

  private Map<String, String> grabRestParams(UriInfo uriInfo) {
    Map<String, String> queryParamsMap = new HashMap<String, String>();
    MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
    String nameParam = queryParams.getFirst("name");

    Iterator<Map.Entry<String, List<String>>> iterator = queryParams.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry<String, List<String>> entry = iterator.next();
      queryParamsMap.put(entry.getKey(), entry.getValue().get(0));
      System.out.printf("Key : %s and Value: %s %n", entry.getKey(), entry.getValue());
      iterator.remove();
    }

    return queryParamsMap;
  }

  @DELETE
  @Path("/{id}")
  @Produces(value = MediaType.APPLICATION_JSON)
//  @ApiOperation(value = "Delete file  by id", produces = MediaType.APPLICATION_JSON)
//  @ApiResponses({
//          @ApiResponse(code = HttpStatus.NOT_FOUND_404,
//                  message = "The requested file could not be found"),
//          @ApiResponse(code = HttpStatus.BAD_REQUEST_400,
//                  message = "The request is not valid. The response body will contain a code and " +
//                          "details specifying the source of the error."),
//          @ApiResponse(code = HttpStatus.UNAUTHORIZED_401,
//                  message = "User is unauthorized to perform the desired operation")
//  })
  public Response deleteFile(
          @ApiParam(name = "id", value = "id of page to delete image content", required = true)
          @PathParam("id") String fileId) {
    String methodName = "deleteFile";
    try {

    } catch (Exception ex) {
      logger.error("api={}", methodName, ex);
      mapAndThrow(ex);
    }
    return Response.status(Response.Status.NO_CONTENT).build();
  }

  private void mapAndThrow(Exception e) {
    // Default status and code
    int status = HttpStatus.INTERNAL_SERVER_ERROR_500;
    String code = "INTERNAL_SERVER_ERROR";

    // Resolve and map standard exceptions
    if (e.getClass().isAssignableFrom(MockingjayDataAccessException.class) ||
            e.getClass().isAssignableFrom(MockingjayGenericException.class) ||
            e.getClass().isAssignableFrom(FileWriterException.class)) {
      status = HttpStatus.INTERNAL_SERVER_ERROR_500;
      code = "INTERNAL_SERVER_ERROR";
    } else if (e.getClass().isAssignableFrom(JsonTransformationException.class)) {
      status = HttpStatus.BAD_REQUEST_400;
      code = "BAD_REQUEST";
    } else if (e.getClass().isAssignableFrom(FileNotFoundException.class)) {
      status = HttpStatus.NOT_FOUND_404;
      code = "RESOURCE_NOT_FOUND";
    } else if (e.getClass().isAssignableFrom(FileStorageException.class)) {
      status = HttpStatus.INSUFFICIENT_STORAGE_507;
      code = "INSUFFICIENT_STORAGE";
    }

    // Throw resource exception
    throw new ResourceException(e, status, code);
  }

  private String findExtractAndReplaceSubStg(String line, String pattern, Map<String, String> varMap) {

    Pattern p = Pattern.compile(pattern);
    // get a matcher object
    Matcher m = p.matcher(line);
    StringBuffer sb = new StringBuffer();
    while (m.find()) {
      //String var = m.group(1);
      String value = varMap.get(m.group(1));
      m.appendReplacement(sb, value);
    }
    m.appendTail(sb);
    System.out.println(sb.toString());
    return sb.toString();
  }

}