package com.edb.demo.tour.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.text.DecimalFormat;

@Getter
public class TransportationInfo {

    private String type;
    private double timeTaken;
    private int cost;

    @Builder
    public TransportationInfo(String type, double timeTaken, int cost) {
        DecimalFormat df = new DecimalFormat("#.##");
        this.type = type;
        this.timeTaken = Double.parseDouble(df.format(timeTaken));
        this.cost = cost;
    }
}
