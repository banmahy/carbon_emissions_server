package com.example.ceserver.model.resp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccommodationResp {

    private Integer priceLevel;

    private Integer population;

    private double carbonEmission;

    private String userId;
}
