package com.example.ceserver.model.param;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccommodationParam {

    private Integer priceLevel;

    private Integer population;

    private String uid;
}
