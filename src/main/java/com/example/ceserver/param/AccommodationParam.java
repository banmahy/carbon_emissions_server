package com.example.ceserver.param;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccommodationParam {

    private String priceLevel;

    private Integer population;
}
