package com.example.Spring_Batch;

import com.example.Spring_Batch.dao.BankTransaction;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

//@Component
public class BankTransactionItemProcessor implements ItemProcessor<BankTransaction,BankTransaction> {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
    @Override
    public BankTransaction process(BankTransaction bankTransaction) throws Exception {
            bankTransaction.setTransactionDate(dateFormat.parse(bankTransaction.getStrTransactionDate()));
        return bankTransaction;
    }
}
