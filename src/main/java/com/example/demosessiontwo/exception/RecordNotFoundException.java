package com.example.demosessiontwo.exception;

public class RecordNotFoundException extends Exception {

  private static final long serialVersionUid = 1L;

  public RecordNotFoundException(String message) {
    super(message);
  }

  public RecordNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
}
