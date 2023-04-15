package com.example.ceserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ceserver.mapper.AccommodationMapper;
import com.example.ceserver.mapper.TrafficMapper;
import com.example.ceserver.model.entity.AccommodationEntity;
import com.example.ceserver.model.entity.ActivityEntity;
import com.example.ceserver.model.entity.TrafficEntity;
import com.example.ceserver.service.AccommodationService;
import com.example.ceserver.service.TrafficService;
import org.springframework.stereotype.Service;

/**
 * @ClassName SysUserServiceImpl
 * @Author
 * @Date
 **/
@Service
public class AccommodationServiceImpl extends ServiceImpl<AccommodationMapper, AccommodationEntity>
        implements AccommodationService {

    @Override
    public AccommodationEntity find(String uid) {
        QueryWrapper<AccommodationEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("uid", uid);
        return baseMapper.selectOne(wrapper);
    }
}
