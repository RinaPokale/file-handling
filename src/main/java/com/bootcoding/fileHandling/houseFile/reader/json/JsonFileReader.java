package com.bootcoding.fileHandling.houseFile.reader.json;

import com.bootcoding.fileHandling.houseFile.reader.MyFileReader;

import java.io.File;
import java.util.List;

public class JsonFileReader implements MyFileReader {
    String path;

    JsonFileReader(String inputFilePath){
        this.path = inputFilePath;
    }

    @Override
    public List read() {
        File file = new File(path);
        return null;
    }
}
