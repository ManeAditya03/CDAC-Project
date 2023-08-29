package com.app.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dtos.TransactionsDto;
import com.app.pojos.TransactionDetail;
import com.app.repositories.TransactionsRepository;

@Service
@Transactional
public class TransactionsServiceImpl implements TransactionsService {
	@Autowired
	private TransactionsRepository transactionsrepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<TransactionsDto> getAllTransactions() {
		List<TransactionsDto> transactionsDtoList = new ArrayList<>();
		List<TransactionDetail> transactionsList = transactionsrepo.findAll();
		for(TransactionDetail td : transactionsList) {
			TransactionsDto dto = mapper.map(td, TransactionsDto.class);
			dto.setFullname(td.getOrder().getUser().getFullname());
			transactionsDtoList.add(dto);
		}
		return transactionsDtoList;
	}
}
