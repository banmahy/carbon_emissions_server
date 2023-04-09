package com.example.ceserver.controller;

import com.example.ceserver.model.param.AccommodationParam;
import com.example.ceserver.model.param.ActivityParam;
import com.example.ceserver.model.param.TrafficParam;
import com.example.ceserver.model.resp.AccommodationResp;
import com.example.ceserver.model.resp.ActivityResp;
import com.example.ceserver.model.resp.TrafficResp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarbonController {

    @RequestMapping("/carbon/traffic")
    public ResponseEntity<TrafficResp> getTraffic(@RequestParam("distance") double distance,
        @RequestParam("population") Integer population) {
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

    @RequestMapping("/carbon/accommodation")
    public ResponseEntity<AccommodationResp> getAccommodation(@RequestParam("priceLevel") String priceLevel,
        @RequestParam("population") Integer population) {
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

    @RequestMapping("/carbon/activity")
    public ResponseEntity<ActivityResp> traffic(@RequestParam("activityLevel") String activityLevel,
        @RequestParam("population") Integer population) {
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
