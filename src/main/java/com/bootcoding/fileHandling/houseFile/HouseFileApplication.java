package com.bootcoding.fileHandling.houseFile;

import com.bootcoding.fileHandling.houseFile.metrics.BedroomMetrics;
import com.bootcoding.fileHandling.houseFile.metrics.BedroomNeighbourhoodMetrics;
import com.bootcoding.fileHandling.houseFile.metrics.NeighbourhoodMetrics;
import com.bootcoding.fileHandling.houseFile.processor.BedroomProcessor;
import com.bootcoding.fileHandling.houseFile.reader.MyFileReader;
import com.bootcoding.fileHandling.houseFile.reader.csv.CsvFileReader;
import com.bootcoding.fileHandling.houseFile.writer.csv.CsvFileWriter;
import com.bootcoding.fileHandling.houseFile.writer.MyFileWriter;
import com.bootcoding.fileHandling.houseFile.writer.json.JsonFileWriter;

import java.util.List;

public class HouseFileApplication {
    public static void main(String[] args) {
        MyFileReader fr = new CsvFileReader("C:/Users/rinap/Downloads/housing_price_dataset.csv");
        BedroomProcessor bp = new BedroomProcessor();
        MyFileWriter fw = new CsvFileWriter();
        JsonFileWriter jfw = new JsonFileWriter();

        List data = fr.read();
        fw.write(bp.getHouse(data, 2), "src/main/resources/2bhk.csv");
        fw.write(bp.getHouse(data, 3), "src/main/resources/3bhk.csv");
        fw.write(bp.getHouse(data, 4), "src/main/resources/4bhk.csv");
        fw.write(bp.getHouse(data, 5), "src/main/resources/5bhk.csv");


        jfw.write(bp.getHouse(data, 2), "src/main/resources/2bhk.json");
        jfw.write(bp.getHouse(data, 3), "src/main/resources/3bhk.json");
        jfw.write(bp.getHouse(data, 4), "src/main/resources/4bhk.json");
        jfw.write(bp.getHouse(data, 5), "src/main/resources/5bhk.json");

        BedroomMetrics bd = new BedroomMetrics();
        bd.collect(data);

        BedroomNeighbourhoodMetrics bdNgh = new BedroomNeighbourhoodMetrics();
        bdNgh.collect(data);

        NeighbourhoodMetrics neighborCount = new NeighbourhoodMetrics();
        neighborCount.collect(data);

        System.out.println(neighborCount.getNeighbourhoodCount(data, "rural"));


    }
}
