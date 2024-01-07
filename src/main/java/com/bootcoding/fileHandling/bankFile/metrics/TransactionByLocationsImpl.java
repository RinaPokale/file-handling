package com.bootcoding.fileHandling.bankFile.metrics;

import com.bootcoding.fileHandling.bankFile.model.BankTransaction;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionByLocationsImpl implements TransactionByLocations{
    @Override
    public void collect(List<BankTransaction> transactions, String city) {
         Map<String, List<BankTransaction>> groupOfCity = transactions.stream().
                 collect(Collectors.groupingBy(BankTransaction::getLocation));

        groupOfCity.forEach((c, records) -> System.out.println(c.equalsIgnoreCase(city)? c + " " + records.size(): ""));

        /*
            groupOfCity.forEach((c, records) -> {
             if(c.equalsIgnoreCase(city)){
                 System.out.println(c + " " + records.size());
             }
         });
         */

    }
}
