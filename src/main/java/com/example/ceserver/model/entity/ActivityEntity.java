package com.example.ceserver.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@TableName("tbl_carbon_activity")
public class ActivityEntity {

    /**
    * id
    */
    private String id;

    /**
    * 用户id
    */
    private String userId;

    /**
    * 人数
    */
    private Integer population;

    /**
    * 活动水平
    */
    private Integer activityLevel;

    /**
    * 碳排量
    */
    private double carbonEmission;
}
