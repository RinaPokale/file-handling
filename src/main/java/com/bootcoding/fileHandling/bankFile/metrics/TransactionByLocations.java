package com.bootcoding.fileHandling.bankFile.metrics;

import com.bootcoding.fileHandling.bankFile.model.BankTransaction;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionByLocations implements MetricsCollector{

    @Override
    public void collect(List<BankTransaction> transactions) {
        Map<String, List<BankTransaction>> groupOfCity = transactions.stream().collect(Collectors.groupingBy(BankTransaction::getLocation));

        groupOfCity.forEach((city, records) -> {
            System.out.println(city + " location " + records.size() + " size");
        });
    }
}
