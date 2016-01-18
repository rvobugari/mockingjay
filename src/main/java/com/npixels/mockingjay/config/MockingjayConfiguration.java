package com.npixels.mockingjay.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;


public class MockingjayConfiguration extends Configuration {

  public String responseDir;

  private String guidanceDir;

  public String getResponseDir() {
    return responseDir;
  }

  public void setResponseDir(String responseDir) {
    this.responseDir = responseDir;
  }


  public String getGuidanceDir() {
    return guidanceDir;
  }

  public void setGuidanceDir(String guidanceDir) {
    this.guidanceDir = guidanceDir;
  }

  @Override
    public String toString()
    {
        return "mockingjayConfiguration{" +
                ", swagger=" + "" +
                ", cors=" + "" +
                '}';
    }
}