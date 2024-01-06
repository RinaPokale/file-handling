package com.bootcoding.fileHandling.bankFile.metrics;

import com.bootcoding.fileHandling.bankFile.model.BankTransaction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionByDateImpl implements TransactionByDate{
    @Override
    public void collect(List<BankTransaction> transactions, int startYear, int endYear) {
        List<BankTransaction> data = new ArrayList<>();
        for(BankTransaction b :transactions){
            if(check(b.getCustomerDob(), startYear, endYear)){
                data.add(b);
            }
        }
        System.out.println(data.size());
    }


    private boolean check(Date customerDob, int startYear, int endYear) {

        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        int year = Integer.parseInt(yearFormat.format(customerDob));
//        System.out.println(year);

        if(year >= startYear && year <= endYear){
            return true;
        }else {
            return false;
        }

    }


}



