package com.binbinxiu.daka.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.binbinxiu.daka.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 支出表
 * </p>
 *
 * @author 
 * @since 2022-11-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_day_expend")
public class TDayExpendEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 支出项
     */
    @TableField("name")
    private String name;

    /**
     * 支出金额
     */
    @TableField("money")
    private BigDecimal money;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private String userId;

    /**
     * 类型
     */
    @TableField("type")
    private String type;


}
