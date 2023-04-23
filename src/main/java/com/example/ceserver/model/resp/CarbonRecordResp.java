package com.example.ceserver.model.resp;

import com.example.ceserver.model.entity.AccommodationEntity;
import com.example.ceserver.model.entity.ActivityEntity;
import com.example.ceserver.model.entity.TrafficEntity;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class CarbonRecordResp {

    private TrafficEntity traffic;

    private AccommodationEntity accommodation;

    private ActivityEntity activity;

    private String suggestion;

    public static final List<String> TRAFFIC_SUGGESTIONS = new ArrayList<>();

    public static final List<String> ACCOMMODATION_SUGGESTIONS = new ArrayList<>();

    public static final List<String> ACTIVITY_SUGGESTIONS = new ArrayList<>();

    public static final List<String> ALL_SUGGESTIONS = new ArrayList<>();

    static {
        TRAFFIC_SUGGESTIONS.add("减少短途飞行，尽可能选择乘坐电动汽车、火车或公共交通工具。");
        TRAFFIC_SUGGESTIONS.add("避免高峰期出行，以避免堵车和长时间等待。");
        TRAFFIC_SUGGESTIONS.add("减少单独驾车出行，尽可能多人拼车或选择共享出行服务。");
        TRAFFIC_SUGGESTIONS.add("选择能源效率较高的交通工具，如混合动力汽车、公共自行车、电动摩托车等。");

        ACCOMMODATION_SUGGESTIONS.add("减少房间占用，尽可能选择与他人合住一间房。");
        ACCOMMODATION_SUGGESTIONS.add("避免长时间使用空调或暖气，适度调整温度以降低碳排放。");
        ACCOMMODATION_SUGGESTIONS.add("避免浪费用水，如洗澡时使用低水流淋浴头，减少冲洗次数等。");
        ACCOMMODATION_SUGGESTIONS.add("避免浪费食物，如只点自己能吃完的食物，尽量减少剩余食物的浪费。");

        ACTIVITY_SUGGESTIONS.add("减少大型活动的组织和参与，例如不必要的商务会议和展览等。");
        ACTIVITY_SUGGESTIONS.add("推广低碳活动，例如徒步旅行、自行车旅行、露营等。");
        ACTIVITY_SUGGESTIONS.add("避免使用一次性餐具和容器，尽可能使用可重复使用的物品。");
        ACTIVITY_SUGGESTIONS.add("选择环保和可持续的旅游活动，如参加环保志愿者项目和社区服务项目等。");

        ALL_SUGGESTIONS.addAll(TRAFFIC_SUGGESTIONS);
        ALL_SUGGESTIONS.addAll(ACCOMMODATION_SUGGESTIONS);
        ALL_SUGGESTIONS.addAll(ACTIVITY_SUGGESTIONS);
    }
}
