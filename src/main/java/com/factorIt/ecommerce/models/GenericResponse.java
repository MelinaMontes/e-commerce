package com.factorIt.ecommerce.models;

import lombok.Data;

@Data
public class GenericResponse {
  private final boolean isOk;
  private final String message;
}
