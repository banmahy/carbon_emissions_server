package com.example.ceserver.resp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TrafficResp {

    private double distance;

    private Integer population;

    private double carbonEmission;

}
