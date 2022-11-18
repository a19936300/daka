package com.binbinxiu.daka.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 任务
 * </p>
 *
 * @author 
 * @since 2022-11-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_ren_wu")
public class TRenWu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableField("name")
    private String name;

    /**
     * 用户id
     */
    @TableField("user_id")
    private String userId;

    /**
     * 类型
     */
    @TableField("type")
    private String type;

    /**
     * 奖励
     */
    @TableField("award")
    private Integer award;

}
