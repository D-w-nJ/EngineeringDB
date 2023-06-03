package com.edb.demo.tour.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class TourOption {
    private String travelPulpose;
    private int hasChild;
    private int crowdPreference;
    private int preferenceNature;
    private int travelDays;

    @Builder
    public TourOption(String travelPulpose, int hasChild, int crowdPreference, int preferenceNature, int travelDays) {
        this.travelPulpose = travelPulpose;
        this.hasChild = hasChild;
        this.crowdPreference = crowdPreference;
        this.preferenceNature = preferenceNature;
        this.travelDays = travelDays;
    }
}
