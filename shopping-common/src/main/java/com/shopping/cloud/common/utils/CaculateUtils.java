package com.shopping.cloud.common.utils;

import com.greenpineyu.fel.FelEngine;
import com.greenpineyu.fel.FelEngineImpl;
import com.greenpineyu.fel.context.FelContext;
import com.shopping.cloud.common.model.dto.BrokerageCalculateDto;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 * 计算工具类
 *
 * @author 34861
 * @create 2017-12-07 10:49
 */
public class CaculateUtils {

    /**
     * 佣金计算
     * 销售净额=销售价-红包抵扣金额
     *计算佣金的毛利额:
     *(销售净额-采购价)-(销售净额-采购价)/(1+销项税率)*销项税率-销售净额*赠送乐富油比例-销售净额*6%-[采购价/(1+销项税率)*销项税率-采购价/(1+进项税率)*进项税率]
     * @author:dison
     * @date 2017/12/07
     */
    public static BigDecimal brokerage(BrokerageCalculateDto brokerageCalculateDto){
        FelEngine fel = new FelEngineImpl();
        FelContext felContext = fel.getContext();
        Map entityMap = JsonUtils.fromJson(JsonUtils.toJson(brokerageCalculateDto),Map.class);
        entityMap.forEach((k,v) ->{
            felContext.set(k.toString(),v);
        });
        return new BigDecimal(fel.eval(brokerageCalculateDto.getFormula()).toString()).setScale(2,BigDecimal.ROUND_HALF_UP);
    }

    public static void main(String[] args) throws Exception{
        /**
         * 销售净额=销售价-红包抵扣金额
         *计算佣金的毛利额:
         *(销售净额-采购价)-(销售净额-采购价)/(1+销项税率)*销项税率-销售净额*赠送乐富油比例-销售净额*6%-[采购价/(1+销项税率)*销项税率-采购价/(1+进项税率)*进项税率]
         * 佣金计算
         */
        BrokerageCalculateDto brokerageCalculateDto = new BrokerageCalculateDto(new BigDecimal(1),new BigDecimal(6),new BigDecimal(6),new BigDecimal(6),new BigDecimal(6),new BigDecimal(6),"(costPrice - redPackage-salePrice) - (costPrice - redPackage-salePrice)/(1 + outputTax) * outputTax - (costPrice - redPackage) * sendLoveuRate - (costPrice - redPackage) * 0.06 " +
                " -(costPrice/(1 + outputTax) * outputTax - costPrice/(1 + inputTax) * inputTax)");
        System.out.println(brokerage(brokerageCalculateDto));
    }
}
