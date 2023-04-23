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
import java.util.Random;

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
        @RequestParam("userId") String userId) {
        TrafficParam trafficParam = TrafficParam.builder()
                .distance(distance)
                .traffic(traffic)
                .population(population)
                .userId(userId)
                .build();
        double carbonEmission = CalculateUtil.getEmission(trafficParam);
        TrafficResp trafficResp = TrafficResp.builder()
                .distance(distance)
                .traffic(traffic)
                .population(population)
                .carbonEmission(carbonEmission)
                .userId(userId)
                .build();
        TrafficEntity trafficEntity = TrafficEntity.builder()
                .distance(distance)
                .traffic(traffic)
                .population(population)
                .carbonEmission(carbonEmission)
                .userId(userId)
                .build();
        boolean save = trafficService.saveOrUpdateByUserId(trafficEntity);
        if (!save) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok(trafficResp);
    }

    @RequestMapping("/carbon/accommodation")
    public ResponseEntity<AccommodationResp> getAccommodation(@RequestParam("priceLevel") Integer priceLevel,
        @RequestParam("population") Integer population,
        @RequestParam("userId") String userId) {
        AccommodationParam accommodation = AccommodationParam.builder()
                .priceLevel(priceLevel)
                .population(population)
                .userId(userId)
                .build();
        double carbonEmission = CalculateUtil.getEmission(accommodation);
        AccommodationResp accommodationResp = AccommodationResp.builder()
                .priceLevel(priceLevel)
                .population(population)
                .carbonEmission(carbonEmission)
                .userId(userId)
                .build();
        AccommodationEntity accommodationEntity = AccommodationEntity.builder()
                .priceLevel(priceLevel)
                .population(population)
                .carbonEmission(carbonEmission)
                .userId(userId)
                .build();
        boolean save = accommodationService.saveOrUpdateByUserId(accommodationEntity);
        if (!save) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok(accommodationResp);
    }

    @RequestMapping("/carbon/activity")
    public ResponseEntity<ActivityResp> getActivity(@RequestParam("activityLevel") Integer activityLevel,
        @RequestParam("population") Integer population,
        @RequestParam("userId") String userId) {
        ActivityParam activityParam = ActivityParam.builder()
                .activityLevel(activityLevel)
                .population(population)
                .userId(userId)
                .build();
        double carbonEmission = CalculateUtil.getEmission(activityParam);
        ActivityResp activityResp = ActivityResp.builder()
                .activityLevel(activityLevel)
                .population(population)
                .carbonEmission(carbonEmission)
                .userId(userId)
                .build();
        ActivityEntity activityEntity = ActivityEntity.builder()
                .activityLevel(activityLevel)
                .population(population)
                .carbonEmission(carbonEmission)
                .userId(userId)
                .build();
        boolean save = activityService.saveOrUpdateByUserId(activityEntity);
        if (!save) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok(activityResp);
    }

    @RequestMapping("/carbon/record")
    public ResponseEntity<CarbonRecordResp> getCarbonRecord(@RequestParam("userId") String userId) {
        TrafficEntity trafficEntity = trafficService.find(userId);
        AccommodationEntity accommodationEntity = accommodationService.find(userId);
        ActivityEntity activityEntity = activityService.find(userId);
        CarbonRecordResp recordResp = CarbonRecordResp.builder().traffic(trafficEntity)
                .accommodation(accommodationEntity)
                .activity(activityEntity)
                .suggestion(CarbonRecordResp.ALL_SUGGESTIONS
                        .get(new Random().nextInt(CarbonRecordResp.ALL_SUGGESTIONS.size())))
                .build();
        return ResponseEntity.ok(recordResp);
    }
}
