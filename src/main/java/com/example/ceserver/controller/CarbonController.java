package com.example.ceserver.controller;

import com.example.ceserver.model.param.AccommodationParam;
import com.example.ceserver.model.param.ActivityParam;
import com.example.ceserver.model.param.TrafficParam;
import com.example.ceserver.model.resp.AccommodationResp;
import com.example.ceserver.model.resp.ActivityResp;
import com.example.ceserver.model.resp.TrafficResp;
import com.example.ceserver.util.CalculateUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarbonController {

    @RequestMapping("/carbon/traffic")
    public ResponseEntity<TrafficResp> getTraffic(@RequestParam("distance") double distance,
        @RequestParam("distance") Integer traffic,
        @RequestParam("population") Integer population,
        @RequestParam("uid") String uid) {
        TrafficParam trafficParam = TrafficParam.builder()
                .distance(distance)
                .population(population)
                .uid(uid)
                .build();
        double carbonEmission = CalculateUtil.getEmission(trafficParam);
        TrafficResp trafficResp = TrafficResp.builder()
                .distance(distance)
                .population(population)
                .carbonEmission(carbonEmission)
                .uid(uid)
                .build();
        return ResponseEntity.ok(trafficResp);
    }

    @RequestMapping("/carbon/accommodation")
    public ResponseEntity<AccommodationResp> getAccommodation(@RequestParam("priceLevel") Integer priceLevel,
        @RequestParam("population") Integer population,
        @RequestParam("uid") String uid) {
        AccommodationParam accommodation = AccommodationParam.builder()
                .priceLevel(priceLevel)
                .population(population)
                .uid(uid)
                .build();
        double carbonEmission = CalculateUtil.getEmission(accommodation);
        AccommodationResp accommodationResp = AccommodationResp.builder()
                .priceLevel(priceLevel)
                .population(population)
                .carbonEmission(carbonEmission)
                .uid(uid)
                .build();
        return ResponseEntity.ok(accommodationResp);
    }

    @RequestMapping("/carbon/activity")
    public ResponseEntity<ActivityResp> traffic(@RequestParam("activityLevel") Integer activityLevel,
        @RequestParam("population") Integer population,
        @RequestParam("uid") String uid) {
        ActivityParam activityParam = ActivityParam.builder()
                .activityLevel(activityLevel)
                .population(population)
                .uid(uid)
                .build();
        double carbonEmission = CalculateUtil.getEmission(activityParam);
        ActivityResp activityResp = ActivityResp.builder()
                .activityLevel(activityLevel)
                .population(population)
                .carbonEmission(carbonEmission)
                .uid(uid)
                .build();
        return ResponseEntity.ok(activityResp);
    }
}
