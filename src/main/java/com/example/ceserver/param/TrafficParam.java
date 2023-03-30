package com.example.ceserver.param;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TrafficParam {

    private double distance;

    private Integer population;
}
