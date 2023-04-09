package com.example.ceserver.model.param;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ActivityParam {

    private Integer activityLevel;

    private Integer population;

    private String uid;
}
