package com.example.ceserver.resp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccommodationResp {

    private String priceLevel;

    private Integer population;

    private double carbonEmission;
}
