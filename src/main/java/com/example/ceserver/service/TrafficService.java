package com.example.ceserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ceserver.model.entity.TrafficEntity;

public interface TrafficService extends IService<TrafficEntity> {

    TrafficEntity find(String uid);
}
