package com.example.ceserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ceserver.model.entity.AccommodationEntity;
import com.example.ceserver.model.entity.ActivityEntity;

public interface ActivityService extends IService<ActivityEntity> {

    ActivityEntity find(String uid);
}
