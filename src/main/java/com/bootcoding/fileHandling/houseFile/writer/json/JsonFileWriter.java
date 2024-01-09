package com.bootcoding.fileHandling.houseFile.writer.json;

import com.bootcoding.fileHandling.houseFile.model.BedroomsCount;
import com.bootcoding.fileHandling.houseFile.writer.MyFileWriter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.time.Instant;
import java.util.List;

public class JsonFileWriter implements MyFileWriter {
    ObjectMapper objectMapper = new ObjectMapper();

    public static void write(BedroomsCount metricResult) {
        try{
            ObjectMapper om = new ObjectMapper();
            String s = om.writeValueAsString(metricResult);
            FileWriter fw = new FileWriter(new File("src/main/resources/bhkNeighbors.json"));
            fw.write(s);
            fw.flush();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void write(List data, String outputPath) {
        // write data into .json file
        try {
            String s = objectMapper.writeValueAsString(data); //convert a Java object to a JSON string.
            FileWriter fw = new FileWriter(new File(outputPath));
            fw.write(s);
            fw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(List data) {

    }

}
