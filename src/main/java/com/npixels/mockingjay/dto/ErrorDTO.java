package com.npixels.mockingjay.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by rvobugari on 1/17/16.
 */

public class ErrorDTO {
  private String code;
  private String message;
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private Object details;


  public ErrorDTO(String code) {
    this.code = code;
  }

  public ErrorDTO(String code, String message, Object details) {
    this.code = code;
    this.message = message;
    this.details = details;
  }

  public ErrorDTO(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Object getDetails() {
    return this.details;
  }

  public void setDetails(Object details) {
    this.details = details;
  }
}

