package com.bootcoding.fileHandling.bankFile;

import com.bootcoding.fileHandling.bankFile.metrics.TransactionByLocationsImpl;
import com.bootcoding.fileHandling.bankFile.model.BankTransaction;
import com.bootcoding.fileHandling.bankFile.reader.TransactionFileReader;

import java.util.List;

public class BankApplication {
    public static void main(String[] args) {
        TransactionFileReader fileReader = new TransactionFileReader();
        String filePath = "C://Users//rinap//Downloads//archive (5)//bank_transactions1.csv";
        List<BankTransaction> bankTransaction = fileReader.read(filePath);

//        MetricsCollector metricsCollector = new TransactionByGenderMetrics();
//        metricsCollector.collect(bankTransaction);
//
        TransactionByLocationsImpl transactionByLocation = new TransactionByLocationsImpl();
        transactionByLocation.collect(bankTransaction, "mumbai");

//        TransactionByDateImpl transactionByDate = new TransactionByDateImpl();
//        transactionByDate.collect(bankTransaction, 1960, 1970);
    }
}
