package com.example.ceserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ceserver.mapper.SysUserMapper;
import com.example.ceserver.mapper.TrafficMapper;
import com.example.ceserver.model.entity.ActivityEntity;
import com.example.ceserver.model.entity.TblSysUser;
import com.example.ceserver.model.entity.TrafficEntity;
import com.example.ceserver.service.SysUserService;
import com.example.ceserver.service.TrafficService;
import org.springframework.stereotype.Service;

/**
 * @ClassName SysUserServiceImpl
 * @Author
 * @Date
 **/
@Service
public class TrafficServiceImpl extends ServiceImpl<TrafficMapper, TrafficEntity> implements TrafficService {

    @Override
    public TrafficEntity find(String uid) {
        QueryWrapper<TrafficEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("uid", uid);
        return baseMapper.selectOne(wrapper);
    }
}
