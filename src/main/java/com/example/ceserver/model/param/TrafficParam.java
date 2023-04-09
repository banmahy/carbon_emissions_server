package com.example.ceserver.model.param;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TrafficParam {

    private double distance;

    private Integer population;

    private Integer traffic;

    private String uid;
}
