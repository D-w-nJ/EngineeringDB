package com.edb.demo.tour.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class TouristAttraction {

    private String region;
    private String destination;
    private String category;
    private String destinationUrl;
    private List<TransportationInfo> transportationInfos;

    @Builder
    public TouristAttraction(String region, String destination, String category, String destinationUrl, List<TransportationInfo> transportationInfos) {
        this.region = region;
        this.destination = destination;
        this.category = category;
        this.destinationUrl = destinationUrl;
        this.transportationInfos = transportationInfos;
    }
}
