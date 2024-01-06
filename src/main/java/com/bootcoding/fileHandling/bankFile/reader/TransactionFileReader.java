package com.bootcoding.fileHandling.bankFile.reader;


import com.bootcoding.fileHandling.bankFile.model.BankTransaction;
import com.bootcoding.fileHandling.bankFile.utils.DateUtils;
import com.opencsv.CSVReader;
import org.apache.commons.lang3.StringUtils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TransactionFileReader {
//Note:- readAll() -> Reads the entire file into a List with each element being a String[] of tokens.
    public List<BankTransaction> read(String filePath) {
        try {
            CSVReader reader = new CSVReader(new FileReader(filePath));
            List<String[]> data = reader.readAll();
            List<BankTransaction> bankTransactions = convert(data);
            return bankTransactions;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return Collections.emptyList();
    }

//    private List<BankTransaction> convert(List<String[]> data) {
//        List<BankTransaction> list = new ArrayList<>();
//        for (String[] row : data) {
//            BankTransaction bankTransaction = buildTransaction(row);
//            list.add(bankTransaction);
//        }
//        return list;
//    }

    private List<BankTransaction> convert(List<String[]> data){
        return data.stream().map(row -> {
            try{
                return buildTransaction(row);
            }catch (Exception ex){
                System.err.println(ex.getMessage() + " while processing : row: " + row);
                return null;
            }
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }

    private BankTransaction buildTransaction(String[] row) throws Exception {

        return BankTransaction.builder()
                .transactionId(row[0])
                .customerId(row[1])
                .customerDob(DateUtils.convertToDate(row[2]))
                .gender(StringUtils.isEmpty(row[3]) ? 'N' : row[3].charAt(0))
                .location(row[4])
                .accountBalance(StringUtils.isEmpty(row[5]) ? 0 : Double.valueOf(row[5]))
                .transactionDate(DateUtils.convertToDate(row[6]))
                .transactionTime(StringUtils.isEmpty(row[7]) ? 0 : Long.valueOf(row[7]))
                .amountInr(StringUtils.isEmpty(row[8]) ? 0 : Double.valueOf(row[8]))
                .build();
    }
}
