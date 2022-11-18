package com.binbinxiu.daka.service;

import com.binbinxiu.daka.entity.TDayExpendEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import weixin.popular.bean.message.EventMessage;

/**
 * <p>
 * 支出表 服务类
 * </p>
 *
 * @author 
 * @since 2022-11-16
 */
public interface TDayExpendService extends IService<TDayExpendEntity> {

    boolean expendRecord(EventMessage eventMessage);
}
