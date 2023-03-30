package com.example.ceserver.resp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ActivityResp {

    private String activityLevel;

    private Integer population;

    private double carbonEmission;
}
