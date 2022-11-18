package com.binbinxiu.daka.service.impl;

import com.binbinxiu.daka.entity.TDayExpendEntity;
import com.binbinxiu.daka.mapper.TDayExpendMapper;
import com.binbinxiu.daka.service.TDayExpendService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.n3r.idworker.Id;
import org.n3r.idworker.IdWorker;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import weixin.popular.bean.message.EventMessage;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * 支出表 服务实现类
 * </p>
 *
 * @author 
 * @since 2022-11-16
 */
@Service
public class TDayExpendServiceImpl extends ServiceImpl<TDayExpendMapper, TDayExpendEntity> implements TDayExpendService {

    private static Pattern pattern = Pattern.compile("\\W*(\\d+(\\.\\d{1,2})?)\\W*");

    @Autowired
    private Sid sid;

    @Override
    public boolean expendRecord(EventMessage eventMessage) {
        TDayExpendEntity expend= new TDayExpendEntity();
        expend.setTenantId(sid.nextShort());
        expend.setUserId(eventMessage.getFromUserName());
        expend.setName(eventMessage.getContent());
        expend.setType("daily");
        expend.setRevision("1");
        Matcher matcher = pattern.matcher(eventMessage.getContent());
        if(matcher.matches()){
            expend.setMoney(new BigDecimal(matcher.group(1)));
            this.save(expend);
            return true;
        }

        return false;
    }

}
