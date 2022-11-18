package com.binbinxiu.daka.service;

import com.binbinxiu.daka.entity.TRenWu;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 任务 服务类
 * </p>
 *
 * @author 
 * @since 2022-11-12
 */
public interface TRenWuService extends IService<TRenWu> {

    String receiveRenWu(String content);

    public String renWuSum();
}
