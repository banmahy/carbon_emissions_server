package com.example.ceserver.controller;

import com.example.ceserver.param.AccommodationParam;
import com.example.ceserver.param.ActivityParam;
import com.example.ceserver.param.TrafficParam;
import com.example.ceserver.resp.AccommodationResp;
import com.example.ceserver.resp.ActivityResp;
import com.example.ceserver.resp.TrafficResp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarbonController {

    @GetMapping("/carbon/traffic?distance={distance}&population={population}")
    public ResponseEntity<TrafficResp> getTraffic(@PathVariable("distance") double distance,
                                                @PathVariable("population") Integer population) {
        TrafficParam trafficParam = TrafficParam.builder()
                .distance(distance)
                .population(population)
                .build();
        double carbonEmission = calculate(trafficParam);
        TrafficResp trafficResp = TrafficResp.builder()
                .distance(distance)
                .population(population)
                .carbonEmission(carbonEmission)
                .build();
        return ResponseEntity.ok(trafficResp);
    }

    @GetMapping("/carbon/accommodation?priceLevel={priceLevel}&population={population}")
    public ResponseEntity<AccommodationResp> getAccommodation(@PathVariable("priceLevel") String priceLevel,
                                               @PathVariable("population") Integer population) {
        AccommodationParam accommodation = AccommodationParam.builder()
                .priceLevel(priceLevel)
                .population(population)
                .build();
        double carbonEmission = calculate(accommodation);
        AccommodationResp accommodationResp = AccommodationResp.builder()
                .priceLevel(priceLevel)
                .population(population)
                .carbonEmission(carbonEmission)
                .build();
        return ResponseEntity.ok(accommodationResp);
    }

    @GetMapping("/carbon/activity?activityLevel={activityLevel}&population={population}")
    public ResponseEntity<ActivityResp> traffic(@PathVariable("activityLevel") String activityLevel,
                                                @PathVariable("population") Integer population) {
        ActivityParam activityParam = ActivityParam.builder()
                .activityLevel(activityLevel)
                .population(population)
                .build();
        double carbonEmission = calculate(activityParam);
        ActivityResp activityResp = ActivityResp.builder()
                .activityLevel(activityLevel)
                .population(population)
                .carbonEmission(carbonEmission)
                .build();
        return ResponseEntity.ok(activityResp);
    }

    private double calculate(Object object) {
        return 0d;
    }
}
