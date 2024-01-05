package com.bootcoding.fileHandling.bankFile.metrics;

import com.bootcoding.fileHandling.bankFile.model.BankTransaction;

import java.util.List;

public interface TransactionByDate {
    public void collect(List<BankTransaction> transactions, int startYear, int endYear);

}
