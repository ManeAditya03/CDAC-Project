package com.app.services;

import java.util.List;

import com.app.dtos.TransactionsDto;

public interface TransactionsService {
	List<TransactionsDto> getAllTransactions();
}
