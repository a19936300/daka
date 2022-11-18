package com.binbinxiu.daka.mapper;

import com.binbinxiu.daka.entity.TRenWu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 任务 Mapper 接口
 * </p>
 *
 * @author 
 * @since 2022-11-12
 */
public interface TRenWuMapper extends BaseMapper<TRenWu> {

    List<TRenWu> renWuSum();
}
