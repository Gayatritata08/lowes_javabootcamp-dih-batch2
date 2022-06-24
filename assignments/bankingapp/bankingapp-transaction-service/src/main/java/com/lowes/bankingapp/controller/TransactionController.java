package com.lowes.bankingapp.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lowes.bankingapp.entity.ResponseMessage;
import com.lowes.bankingapp.entity.Transaction;
import com.lowes.bankingapp.service.TransactionServcie;

@RestController
@RequestMapping("/transaction")

public class TransactionController {

	@Autowired
	TransactionServcie transService;

//		Create Order 	POST	/orders
//		Get All Orders	GET		/orders
//		Update Order	PUT		/orders/{id}
//		Delete Order	DELETE	/orders/{id}
//		Get Order		GET		/orders/{id}

	@PostMapping
	public ResponseEntity<ResponseMessage> createOrder(@RequestBody @Valid Transaction trasaction) throws Exception {

		transService.create(trasaction);

		// Getting current resource path
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(trasaction.getId())
				.toUri();

		return ResponseEntity.created(location).body(this.getResponse(trasaction.getId(), "Transaction Created"));
	}

	@GetMapping
	public List<Transaction> getAll() {
		return transService.list();
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseMessage> updateOrder(@RequestBody @Valid Transaction trasaction,
			@PathVariable Integer id) {
		trasaction.setId(id);
		transService.update(trasaction);

		return ResponseEntity.ok().body(this.getResponse(trasaction.getId(), "Transaction Updated"));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseMessage> deleteOrder(@PathVariable Integer id) {
		transService.delete(id);

		ResponseMessage response = getResponse(id, "Transaction Deleted");

		return ResponseEntity.accepted().body(response);
	}

	@GetMapping("/{id}")
	public Transaction getOrder(@PathVariable Integer id) {
		return transService.get(id);
	}

	private ResponseMessage getResponse(Integer id, String message) {
		ResponseMessage response = new ResponseMessage();
		response.setId(id);
		response.setStatus(HttpStatus.OK.name());
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage(message);
		return response;
	}

	private ResponseMessage getErrorResponse(Integer id, String message) {
		ResponseMessage response = new ResponseMessage();
		response.setId(id);
		response.setStatus(HttpStatus.BAD_REQUEST.name());
		response.setStatusCode(HttpStatus.BAD_REQUEST.value());
		response.setMessage(message);
		return response;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	private ResponseEntity<ResponseMessage> handleValidationException(MethodArgumentNotValidException ex) {
		FieldError error = ex.getBindingResult().getFieldError("name");
		System.out.println("Error Message: " + error.getCode() + " - " + error.getDefaultMessage());
		return ResponseEntity.badRequest().body(this.getErrorResponse(-1, error.getDefaultMessage()));
	}
}
