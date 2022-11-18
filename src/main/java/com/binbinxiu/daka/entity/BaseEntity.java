package com.binbinxiu.daka.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter@Setter
public class BaseEntity {
    private String tenantId;
    private String revision;
    private String createdBy;
    @TableField(value = "created_time",fill = FieldFill.INSERT)
    private LocalDateTime createdTime;
    private String updatedBy;
    @TableField(value = "updated_time",fill = FieldFill.INSERT_UPDATE)
    private String updatedTime;
}
