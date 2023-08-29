package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.TransactionsDto;
import com.app.services.TransactionsService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/transaction")
public class TransactionsController {
	@Autowired
	private TransactionsService transactionsService;
	
	@GetMapping
	public ResponseEntity<?> getAllTransactions() {
		List<TransactionsDto> transactionsList = transactionsService.getAllTransactions();
		return new ResponseEntity<>(transactionsList, HttpStatus.OK);
	}
}
