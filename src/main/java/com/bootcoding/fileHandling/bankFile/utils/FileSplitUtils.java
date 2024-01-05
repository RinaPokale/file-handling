package com.bootcoding.fileHandling.bankFile.utils;

import com.google.common.collect.Lists;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.List;

public class FileSplitUtils {
    public static void main(String[] args) {
        split("C:/Users/rinap/Downloads/archive(5)/bank_transactions1.csv", 50000, "src/main/resources");
    }
    public static void split(String inputPath, int partitionCount, String outputFolder){
        try{
            CSVReader csvReader = new CSVReader(new FileReader(inputPath));
            List<String[]> data = csvReader.readAll();

            List<List<String[]>> partitionData = Lists.partition(data, partitionCount);

            for(List<String[]> subList: partitionData){
                CSVWriter csvWriter = new CSVWriter(new FileWriter(outputFolder + "/" + (Instant.now().getNano()) + ".csv"));
                csvWriter.writeAll(subList);
            }

        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
