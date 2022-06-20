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

import com.lowes.bankingapp.entity.FundsTransfer;
import com.lowes.bankingapp.entity.ResponseMessage;
import com.lowes.bankingapp.service.FundsTransferService;

@RestController
@RequestMapping("/fundstransfer")
public class FundsTransferController {

	@Autowired
	FundsTransferService fundTranService;

//	Create Customer 	POST	/Customers
//	Get All Customers	GET		/Customers
//	Update Customer		PUT		/Customers/{id}
//	Delete Customer		DELETE	/Customers/{id}
//	Get Customer		GET		/Customers/{id}

	@PostMapping
	public ResponseEntity<ResponseMessage> create(@RequestBody @Valid FundsTransfer fundTranObj) throws Exception {
		// Uncomment to test Generic Exception Handling behaviour
//			if(Customer.getName().contains("test"))
//			{
//				throw new Exception("Invalid Name");
//			}

		fundTranService.add(fundTranObj);

		// Getting current resource path
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fundTranObj.getTargetAccoundId())
				.toUri();

		return ResponseEntity.created(location).body(this.getResponse(fundTranObj.getTargetAccoundId(), "Customer Created"));
	}

	@GetMapping
	public List<FundsTransfer> getAll() {
		return fundTranService.list();
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseMessage> updateCustomer(@RequestBody @Valid FundsTransfer fundTransObj,
			@PathVariable Integer id) {
		fundTransObj.setTargetAccoundId(id);
		fundTranService.update(fundTransObj);

		return ResponseEntity.ok().body(this.getResponse(fundTransObj.getTargetAccoundId(), "Customer Updated"));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseMessage> deleteCustomer(@PathVariable Integer id) {
		fundTranService.delete(id);

		ResponseMessage response = getResponse(id, "Customer Deleted");

		return ResponseEntity.accepted().body(response);
	}

	@GetMapping("/{id}")
	public FundsTransfer getCustomer(@PathVariable Integer id) {
		return fundTranService.get(id);
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
