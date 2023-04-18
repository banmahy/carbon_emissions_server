package com.example.ceserver.controller;

import com.example.ceserver.model.entity.AccommodationEntity;
import com.example.ceserver.model.entity.ActivityEntity;
import com.example.ceserver.model.entity.TrafficEntity;
import com.example.ceserver.model.param.AccommodationParam;
import com.example.ceserver.model.param.ActivityParam;
import com.example.ceserver.model.param.TrafficParam;
import com.example.ceserver.model.resp.AccommodationResp;
import com.example.ceserver.model.resp.ActivityResp;
import com.example.ceserver.model.resp.CarbonRecordResp;
import com.example.ceserver.model.resp.TrafficResp;
import com.example.ceserver.service.AccommodationService;
import com.example.ceserver.service.ActivityService;
import com.example.ceserver.service.TrafficService;
import com.example.ceserver.util.CalculateUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
public class CarbonController {

    @Resource
    private TrafficService trafficService;

    @Resource
    private AccommodationService accommodationService;

    @Resource
    private ActivityService activityService;

    @RequestMapping("/carbon/traffic")
    public ResponseEntity<TrafficResp> getTraffic(@RequestParam("distance") Double distance,
        @RequestParam("traffic") Integer traffic,
        @RequestParam("population") Integer population,
        @RequestParam("uid") String uid) {
        TrafficParam trafficParam = TrafficParam.builder()
                .distance(distance)
                .traffic(traffic)
                .population(population)
                .uid(uid)
                .build();
        double carbonEmission = CalculateUtil.getEmission(trafficParam);
        TrafficResp trafficResp = TrafficResp.builder()
                .distance(distance)
                .traffic(traffic)
                .population(population)
                .carbonEmission(carbonEmission)
                .uid(uid)
                .build();
        TrafficEntity trafficEntity = TrafficEntity.builder()
                .distance(distance)
                .traffic(traffic)
                .population(population)
                .carbonEmission(carbonEmission)
                .uid(uid)
                .build();
        boolean save = trafficService.save(trafficEntity);
        if (!save) {
            return ResponseEntity.internalServerError().build();
        }
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
        AccommodationEntity accommodationEntity = AccommodationEntity.builder()
                .priceLevel(priceLevel)
                .population(population)
                .carbonEmission(carbonEmission)
                .uid(uid)
                .build();
        boolean save = accommodationService.save(accommodationEntity);
        if (!save) {
            return ResponseEntity.internalServerError().build();
        }
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
        ActivityEntity activityEntity = ActivityEntity.builder()
                .activityLevel(activityLevel)
                .population(population)
                .carbonEmission(carbonEmission)
                .uid(uid)
                .build();
        boolean save = activityService.save(activityEntity);
        if (!save) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok(activityResp);
    }

    @RequestMapping("/carbon/record")
    public ResponseEntity<CarbonRecordResp> traffic(@RequestParam("uid") String uid) {
        TrafficEntity trafficEntity = trafficService.find(uid);
        AccommodationEntity accommodationEntity = accommodationService.find(uid);
        ActivityEntity activityEntity = activityService.find(uid);
        CarbonRecordResp recordResp = CarbonRecordResp.builder().traffic(trafficEntity)
                .accommodation(accommodationEntity)
                .activity(activityEntity)
                .build();
        return ResponseEntity.ok(recordResp);
    }
}
