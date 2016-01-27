package com.npixels.mockingjay.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;


public class MockingjayConfiguration extends Configuration {

  @NotEmpty
  @JsonProperty("responseDir")
  public String responseDir;

  @NotEmpty
  @JsonProperty("guidanceDir")
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