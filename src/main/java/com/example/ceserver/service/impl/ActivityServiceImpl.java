package com.example.ceserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ceserver.mapper.AccommodationMapper;
import com.example.ceserver.mapper.ActivityMapper;
import com.example.ceserver.model.entity.AccommodationEntity;
import com.example.ceserver.model.entity.ActivityEntity;
import com.example.ceserver.service.AccommodationService;
import com.example.ceserver.service.ActivityService;
import org.springframework.stereotype.Service;

/**
 * @ClassName SysUserServiceImpl
 * @Author
 * @Date
 **/
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, ActivityEntity>
        implements ActivityService {

    @Override
    public ActivityEntity find(String uid) {
        QueryWrapper<ActivityEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("uid", uid);
        return baseMapper.selectOne(wrapper);
    }
}
