package com.example.ceserver.model.resp;

import com.example.ceserver.model.entity.AccommodationEntity;
import com.example.ceserver.model.entity.ActivityEntity;
import com.example.ceserver.model.entity.TrafficEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarbonRecordResp {

    private TrafficEntity traffic;

    private AccommodationEntity accommodation;

    private ActivityEntity activity;
}
