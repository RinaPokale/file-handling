package com.bootcoding.fileHandling.houseFile.writer;

import java.util.List;

public interface MyFileWriter extends DataWriter{
    public void write(List data, String outputPath);
}

