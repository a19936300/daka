package com.binbinxiu.daka.filter;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class MyMetaObjectHandler  implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start install fill ....");
        this.strictInsertFill(metaObject,"createdTime", LocalDateTime.class,LocalDateTime.now());
        this.strictUpdateFill(metaObject,"updatedTime", LocalDateTime.class,LocalDateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.strictUpdateFill(metaObject,"updatedTime", LocalDateTime.class,LocalDateTime.now());
    }
}
