package com.example.Spring_Batch.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class App {
    public static void main(String[] args) throws ParseException {
        BankTransaction b = new BankTransaction();
        b.setStrTransactionDate("11/12/2020-22:10");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
        b.setTransactionDate(dateFormat.parse(b.getStrTransactionDate()));
        System.out.println(b.getTransactionDate());
    }
}
