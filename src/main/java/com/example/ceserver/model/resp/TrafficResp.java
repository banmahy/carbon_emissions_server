package com.example.ceserver.model.resp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TrafficResp {

    private double distance;

    private Integer population;

    private Integer traffic;

    private double carbonEmission;

    private String uid;

}
