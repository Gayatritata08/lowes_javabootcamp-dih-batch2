package com.lowes.bankingapp.exception;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.exception.JDBCConnectionException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.lowes.bankingapp.controller.ResponseMessage;

@ControllerAdvice
@RestController
public class EmployeeExceptionHandler extends ResponseEntityExceptionHandler {

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {

			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseMessage> handleGenericErrors(Exception ex) {
		ResponseMessage response = new ResponseMessage("Failure", ex.getMessage());
		return ResponseEntity.internalServerError().body(response);
	}

	@ExceptionHandler(EmployeeNotFoundException.class)
	public final ResponseEntity<ResponseMessage> handleUserNotFoundException(EmployeeNotFoundException ex,
			WebRequest request) {
		ResponseMessage responseMessage = new ResponseMessage(ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(responseMessage, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(JDBCConnectionException.class)
	public final ResponseEntity<ResponseMessage> databaseError(JDBCConnectionException ex, WebRequest request) {
		ResponseMessage responseMessage = new ResponseMessage("Error", "An error occurred connecting to the database");
		return ResponseEntity.internalServerError().body(responseMessage);
	}

	@ExceptionHandler(CannotCreateTransactionException.class)
	public ResponseEntity<ResponseMessage> handleDatabaseConnectionErrors(CannotCreateTransactionException ex) {
		ResponseMessage response = new ResponseMessage("Failure db", "Database Error with Message: " + ex.getMessage());
		return ResponseEntity.internalServerError().body(response);
	}
}