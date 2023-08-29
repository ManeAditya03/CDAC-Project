package com.app.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.TransactionDetail;

@Repository
public interface TransactionsRepository extends JpaRepository<TransactionDetail, Long> {

}
