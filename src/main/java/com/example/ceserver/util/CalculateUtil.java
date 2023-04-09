package com.example.ceserver.util;

import com.example.ceserver.model.param.AccommodationParam;
import com.example.ceserver.model.param.ActivityParam;
import com.example.ceserver.model.param.TrafficParam;

public class CalculateUtil {

    private static final double PLANE_EMISSION = 0.139d;
    private static final double TRAINS_EMISSION = 0.00004d;
    private static final double CAR_EMISSION = 0.000052d;

    private static final double LOW_HOTEL = 22.1d;
    private static final double MID_HOTEL = 44.2d;
    private static final double HIGH_HOTEL = 66.3d;

    private static final double LOW_ACTIVITY = 22.1d;
    private static final double MID_ACTIVITY = 44.2d;
    private static final double HIGH_ACTIVITY = 66.3d;

    public static double getEmission(TrafficParam trafficParam) {
        Integer traffic = trafficParam.getTraffic();
        double distance = trafficParam.getDistance();
        Integer population = trafficParam.getPopulation();
        switch (traffic) {
            case 0:
                return CAR_EMISSION * distance * population;
            case 1:
                return TRAINS_EMISSION * distance * population;
            case 2:
                return PLANE_EMISSION * distance * population;
            default:
                return 0d;
        }
    }

    public static double getEmission(AccommodationParam accommodationParam) {
        Integer priceLevel = accommodationParam.getPriceLevel();
        Integer population = accommodationParam.getPopulation();
        switch (priceLevel) {
            case 0:
                return LOW_HOTEL * population;
            case 1:
                return MID_HOTEL * population;
            case 2:
                return HIGH_HOTEL * population;
            default:
                return 0d;
        }
    }
    public static double getEmission(ActivityParam activityParam) {
        Integer activityLevel = activityParam.getActivityLevel();
        Integer population = activityParam.getPopulation();
        switch (activityLevel) {
            case 0:
                return LOW_ACTIVITY * population;
            case 1:
                return MID_ACTIVITY * population;
            case 2:
                return HIGH_ACTIVITY * population;
            default:
                return 0d;
        }
    }
}
