package com.example.Spring_Batch;

import com.example.Spring_Batch.dao.BankTransaction;
import lombok.Getter;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

//@Component
public class BankTransactionItemAnalystProcessor implements ItemProcessor<BankTransaction,BankTransaction> {
    @Getter private double totaleDebit;
    @Getter private double totaleCredit;
    @Override
    public BankTransaction process(BankTransaction bankTransaction) throws Exception {
            if(bankTransaction.getTransactionType().equals("D")) totaleDebit+=bankTransaction.getAmount();
            else if(bankTransaction.getTransactionType().equals("C")) totaleCredit+=bankTransaction.getAmount();
            return bankTransaction;
    }
}
