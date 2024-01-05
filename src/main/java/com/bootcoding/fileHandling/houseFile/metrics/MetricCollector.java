package com.bootcoding.fileHandling.houseFile.metrics;

import com.bootcoding.fileHandling.houseFile.model.House;

import java.util.List;

public interface MetricCollector {
    void collect(List<House> data);
}
