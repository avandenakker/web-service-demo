package nl.ilionx.webservicedemo.web.exception;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import nl.ilionx.webservicedemo.internal.DemoObjectNotFoundException;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = { DemoObjectNotFoundException.class })
	public ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex) throws IOException {
		return new ResponseEntity(new ErrorDetails(new Date(), "Object is not found", ex.getMessage()),HttpStatus.NOT_FOUND);
	}
}
