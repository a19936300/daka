package com.binbinxiu.daka.service.impl;

import com.binbinxiu.daka.entity.TRenWu;
import com.binbinxiu.daka.enums.RenWuTypeEnum;
import com.binbinxiu.daka.mapper.TRenWuMapper;
import com.binbinxiu.daka.service.TRenWuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 任务 服务实现类
 * </p>
 *
 * @author 
 * @since 2022-11-12
 */
@Service
public class TRenWuServiceImpl extends ServiceImpl<TRenWuMapper, TRenWu> implements TRenWuService {

    @Autowired
    private TRenWuMapper renWuMapper;

    @Override
    public String receiveRenWu(String content) {
        String[] split = content.split("=");
        TRenWu tRenWu = new TRenWu();
        tRenWu.setName(split[0]);
        tRenWu.setType(RenWuTypeEnum.NO_TYPE.value);
        tRenWu.setAward(Integer.valueOf(split[1]));
        tRenWu.setUserId("1");
        tRenWu.setCreatedBy("1");
        this.save(tRenWu);
        return "记录成功";
    }


    /**
     * 获取任务统计结果
     */
    public String renWuSum(){
        StringBuffer result = new StringBuffer();
        List<TRenWu> wuSumMap = renWuMapper.renWuSum();

        Integer sum = 0;
        for (TRenWu tRenWu : wuSumMap) {
            result.append("类型："+RenWuTypeEnum.getName(tRenWu.getType())+" 总计:"+tRenWu.getAward()).append("\n");
            sum += tRenWu.getAward();
        }

        result.append("总计："+sum);
        return result.toString();
    }
}
