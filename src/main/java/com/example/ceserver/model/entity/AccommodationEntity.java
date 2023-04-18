package com.example.ceserver.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@TableName("tbl_carbon_accommodation")
public class AccommodationEntity {

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
    * 价格水平
    */
    private Integer priceLevel;

    /**
    * 碳排量
    */
    private double carbonEmission;
}
