package com.example.ceserver.utils;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ClassName MPObjectHandler //处理更新时间与插入时间
 * @Author
 * @Date
 **/
@Component
public class MPObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        setFieldValByName("createTime", new Date(),metaObject);
        setFieldValByName("updateTime", new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("updateTime", new Date(),metaObject);
    }
}
