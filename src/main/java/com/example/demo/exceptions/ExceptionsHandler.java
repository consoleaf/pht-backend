package com.example.demo.exceptions;

import com.example.demo.contract.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler
  public ResponseEntity<Object> handleAnyException(Exception e,
                                                   WebRequest request) {
    return new ResponseEntity<>(e, new HttpHeaders(),
                                HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ErrorResponse>
  handleNotFoundException(NotFoundException e, WebRequest request) {
    return new ResponseEntity<>(new ErrorResponse(e), new HttpHeaders(),
                                HttpStatus.NOT_FOUND);
  }
}
