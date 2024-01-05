package com.bootcoding.fileHandling.houseFile.metrics;

import com.bootcoding.fileHandling.houseFile.model.House;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BedroomMetrics implements  MetricCollector{

    //Requirements?
    /*
        2 BHK --> list of house
        3 BHK --> list of house
        4 BHK --> list of house
        5 BHK --> list of house
     */
    @Override
    public void collect(List<House> data) {
        //bedrooms size = 4
        Map<Integer, List<House>> bedrooms = data.stream().collect(Collectors.groupingBy(House::getBedrooms));

        bedrooms.forEach((k,v) -> System.out.println(k + " BHK: " + v.size()));

//      Note:- groupingBy() create sub-group based on the specific criteria

    }
}
