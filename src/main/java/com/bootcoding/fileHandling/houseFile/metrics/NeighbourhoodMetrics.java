package com.bootcoding.fileHandling.houseFile.metrics;

import com.bootcoding.fileHandling.houseFile.model.House;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//what is requirements?
// Houses -> Neighbours - Rural - count
// Houses -> Neighbours - Suburb - count
// Houses -> Neighbours - Urban - count

public class NeighbourhoodMetrics implements MetricCollector{
    @Override
    public void collect(List<House> data) {
        Map<String, List<House>> neighborData = data.stream().collect(Collectors.groupingBy(House::getNeighborhood));

        neighborData.forEach((neighbor, records) -> System.out.println(neighbor + " " + records.size()));
    }

    public long getNeighbourhoodCount(List<House> data, String condition){
        return data.stream()
                .filter(row -> condition.equalsIgnoreCase(row.getNeighborhood()))
                .count();

    }
}
