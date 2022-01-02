package com.example.Spring_Batch.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface BankTransactionRepo extends JpaRepository<BankTransaction,Long> {

}
