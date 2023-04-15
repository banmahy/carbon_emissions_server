package com.example.ceserver.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
@TableName("tbl_carbon_traffic")
public class TrafficEntity {

    /**
    * id
    */
    private String id;

    /**
    * 记录id
    */
    private String uid;

    /**
    * 用户id
    */
    private String userId;

    /**
    * 交通工具
    */
    private Integer traffic;

    /**
    * 人数
    */
    private Integer population;

    /**
    * 距离
    */
    private double distance;

    /**
    * 碳排量
    */
    private double carbonEmission;
}
