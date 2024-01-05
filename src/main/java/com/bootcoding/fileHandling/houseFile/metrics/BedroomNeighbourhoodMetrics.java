package com.bootcoding.fileHandling.houseFile.metrics;

import com.bootcoding.fileHandling.houseFile.model.BedroomsCount;
import com.bootcoding.fileHandling.houseFile.model.House;
import com.bootcoding.fileHandling.houseFile.model.NeighbourhoodCount;
import com.bootcoding.fileHandling.houseFile.writer.json.JsonFileWriter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BedroomNeighbourhoodMetrics implements MetricCollector{
    //Requirements?
    /*
         //bedrooms
         2: houses (5k)
             "Rural", houses (1k)
             "Urban", houses (2k)
             "Suburb", houses (2k)
         3: houses (10k)
             "Rural", houses (1k)
             "Urban", houses (2k)
             "Suburb", houses (2k)
         4: houses (7k)
             "Rural", houses (1k)
             "Urban", houses (2k)
             "Suburb", houses (2k)
         5: houses (6k)
             "Rural", houses (1k)
             "Urban", houses (2k)
             "Suburb", houses (2k)
     */

    @Override
    public void collect(List<House> data) {
        //bedrooms size = 4
        //bedrooms ->  2: List of houses
        Map<Integer, List<House>> bedrooms = data.stream().collect(Collectors.groupingBy(House::getBedrooms));
        bedrooms.forEach((bhk, records)->{
            Map<String, List<House>> bhkNeighbors = groupingByNeighborhood(records);
            //bhkNeighbors size = 3
            /* bhkNeighbors ->
                "Rural", list of houses
                "Urban", list of houses
                "Suburb", list of houses
             */
            System.out.print(bhk + " BHK:" + records.size());
            bhkNeighbors.forEach((k, v) -> System.out.print(" ["+ k+":"+ v.size()+"],"));
            System.out.println();
        });


        Map<Integer, NeighbourhoodCount> countData  = new HashMap<>();

        bedrooms.forEach((bhk, records) ->{
            Map<String, List<House>> bhkNeighbors = groupingByNeighborhood(records);
            System.out.print(" "+bhk + " BHK:" + records.size());
            final NeighbourhoodCount neighbourhoodCount  = NeighbourhoodCount.builder().total(records.size()).build();

            bhkNeighbors.entrySet().forEach((entry) -> {
                setValues(entry, neighbourhoodCount);
            });
            countData.put(bhk, neighbourhoodCount);

        });

        BedroomsCount bedroomsCount = BedroomsCount.builder().bedrooms(countData).build();
        JsonFileWriter.write(bedroomsCount);


    }

    private Map<String, List<House>> groupingByNeighborhood(List<House> records){
        return records.stream().collect(Collectors.groupingBy(House::getNeighborhood));
    }

    private void setValues(Map.Entry<String, List<House>> entry, NeighbourhoodCount neighbourhoodCount) {
        if("Rural".equals(entry.getKey())){
            neighbourhoodCount.setRural(entry.getValue().size());
        } else if("Suburb".equals(entry.getKey())){
            neighbourhoodCount.setSuburb(entry.getValue().size());
        } else if("Urban".equals(entry.getKey())){
            neighbourhoodCount.setUrban(entry.getValue().size());
        }
    }
}

/*
 2 bhk :
    total -> 12436
    Rural ->
    Suburb ->
    Urban ->

  3 bhk :
    total -> 12436
    Rural ->
    Suburb ->
    Urban ->


 */
