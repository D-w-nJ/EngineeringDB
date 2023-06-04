package com.edb.demo.tour.dto.request;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
public class TourOption {
    @ApiModelProperty(value = "여행목적", example = "관광")
    private String travelPulpose;
    @ApiModelProperty(value = "아이동행여부", example = "1")
    private int hasChild;
    @ApiModelProperty(value = "도시혼잡도 정도", example = "6")
    private int crowdPreference;
    @ApiModelProperty(value = "자연친화도 정도", example = "7")
    private int preferenceNature;
    @ApiModelProperty(value = "여행기간", example = "5")
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
