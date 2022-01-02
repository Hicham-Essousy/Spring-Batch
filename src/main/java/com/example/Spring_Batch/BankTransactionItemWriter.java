package com.example.Spring_Batch;

import com.example.Spring_Batch.dao.BankTransaction;
import com.example.Spring_Batch.dao.BankTransactionRepo;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BankTransactionItemWriter implements ItemWriter<BankTransaction> {
    @Autowired private BankTransactionRepo bankTransactionRepo;
    @Override
    public void write(List<? extends BankTransaction> list) throws Exception {
        bankTransactionRepo.saveAll(list);
    }
}
