package com.bootcoding.fileHandling.bankFile;

import com.bootcoding.fileHandling.bankFile.metrics.TransactionByDateImpl;
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
//        TransactionByLocations transactionByLocation = new TransactionByLocations();
//        transactionByLocation.collect(bankTransaction);

        TransactionByDateImpl transactionByDate = new TransactionByDateImpl();
        transactionByDate.collect(bankTransaction, 1960, 1970);
    }
}
