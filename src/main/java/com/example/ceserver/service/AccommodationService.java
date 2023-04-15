package com.example.ceserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ceserver.model.entity.AccommodationEntity;
import com.example.ceserver.model.entity.TrafficEntity;

public interface AccommodationService extends IService<AccommodationEntity> {

    AccommodationEntity find(String uid);
}
