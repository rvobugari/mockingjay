package com.npixels.mockingjay.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by rvobugari on 12/30/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocationGuidanceDTO {

    private String requestType;
    private String restApiPath;
    private String responseBodyFile;
    private String responseHeaderFile;
    private String responseCode;

    public LocationGuidanceDTO() {

    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getRestApiPath() {
        return restApiPath;
    }

    public void setRestApiPath(String restApiPath) {
        this.restApiPath = restApiPath;
    }

    public String getResponseBodyFile() {
        return responseBodyFile;
    }

    public void setResponseBodyFile(String responseBodyFile) {
        this.responseBodyFile = responseBodyFile;
    }

    public String getResponseHeaderFile() {
        return responseHeaderFile;
    }

    public void setResponseHeaderFile(String responseHeaderFile) {
        this.responseHeaderFile = responseHeaderFile;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
}


