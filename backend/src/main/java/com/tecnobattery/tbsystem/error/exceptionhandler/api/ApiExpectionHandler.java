package com.tecnobattery.tbsystem.error.exceptionhandler.api;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.tecnobattery.tbsystem.error.exception.BusinessException;
import com.tecnobattery.tbsystem.error.exceptionhandler.model.Field;
import com.tecnobattery.tbsystem.error.exceptionhandler.model.Problem;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExpectionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<Object> handleBusiness(BusinessException ex, WebRequest request) {
    var status = HttpStatus.BAD_REQUEST;

    var problem = new Problem();
    problem.setStatus(status.value());
    problem.setTitle(ex.getMessage());
    problem.setMoment(LocalDateTime.now());

    return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request) {

    var fields = new ArrayList<Field>();
    for (ObjectError error : ex.getBindingResult().getAllErrors()) {
      String name = ((FieldError) error).getField();
      String message = error.getDefaultMessage();
      fields.add(new Field(name, message));
    }

    var problem = new Problem();
    problem.setStatus(status.value());
    problem.setTitle("Um ou mais campos estão inválidos.");
    problem.setMoment(LocalDateTime.now());
    problem.setFields(fields);
    return super.handleExceptionInternal(ex, problem, headers, status, request);
  }
}
