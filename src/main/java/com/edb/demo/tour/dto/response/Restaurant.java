package com.edb.demo.tour.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Restaurant {

    private String name;
    private String category;
    private String address;

    @Builder
    public Restaurant(String name, String category, String address) {
        this.name = name;
        this.category = category;
        this.address = address;
    }
}
