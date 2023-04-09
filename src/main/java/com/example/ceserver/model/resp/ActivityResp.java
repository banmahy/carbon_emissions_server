package com.example.ceserver.model.resp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ActivityResp {

    private Integer activityLevel;

    private Integer population;

    private double carbonEmission;

    private String uid;
}
