package pl.orderfood;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
  // ...
  @ExceptionHandler(BindException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ModelAndView handleBindException(BindException ex) {
  String message = String.format("Bad request for field: [%s], wrong value: [%s]",
  Optional.ofNullable(ex.getFieldError()).map(FieldError::getField).orElse(null),
  Optional.ofNullable(ex.getFieldError()).map(FieldError::getRejectedValue).orElse(null));
  log.error(message, ex);
  ModelAndView modelView = new ModelAndView("error");
  modelView.addObject("errorMessage", message);
  return modelView;
  }
}