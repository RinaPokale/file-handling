package com.bootcoding.fileHandling.houseFile.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class House {
    int squareFeet;
    int bedrooms;
    int bathrooms;
    String neighborhood;
    int year;
    double price;

}
