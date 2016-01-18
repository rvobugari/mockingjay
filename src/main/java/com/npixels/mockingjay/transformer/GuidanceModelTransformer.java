package com.npixels.mockingjay.transformer;


import com.npixels.mockingjay.exception.JsonTransformationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import com.npixels.mockingjay.dto.LocationGuidanceDTO;

import java.io.File;


/**
 * Created by rvobugari on 12/30/15.
 */

@Component
public class GuidanceModelTransformer {

  public LocationGuidanceDTO toGuidanceModel(File jsonFile) {
    LocationGuidanceDTO data;
    try {
      data = new ObjectMapper().readValue(jsonFile, LocationGuidanceDTO.class);
    } catch (Exception e) {
      throw new JsonTransformationException("Failed to parse JSON: '" + jsonFile.toString() + "'", e);
    }
    return data;
  }
}