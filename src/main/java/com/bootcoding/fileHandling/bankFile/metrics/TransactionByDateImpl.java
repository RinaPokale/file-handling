package com.bootcoding.fileHandling.bankFile.metrics;

import com.bootcoding.fileHandling.bankFile.model.BankTransaction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

//    public List<House> getHouse(List<House> houses, int bSize){
//        return houses.stream().filter(h -> h.getBedrooms() == bSize)
//                .collect(Collectors.toList());
//    }


//    Note:- just method name is different otherwise functionality is same of both methods
    /*
     private static List<House> collectNbhkData(List<House> houses, int bSize){
        List<House> houseNbhk = new ArrayList<>();
        for(int i = 0; i < houses.size(); i++){
            if(houses.get(i).getBedrooms()==bSize){
                houseNbhk.add(houses.get(i));
            }
        }
        return houseNbhk;
    }

     */


