package com.shopping.cloud.common.model.dto;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述:
 * 佣金計算实体
 *
 * @author 34861
 * @create 2017-12-07 10:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrokerageCalculateDto {

    @ApiModelProperty("进价")
    private BigDecimal costPrice;
    @ApiModelProperty("售价")
    private BigDecimal salePrice;
    @ApiModelProperty("红包抵扣额")
    private BigDecimal redPackage;
    @ApiModelProperty("销项税")
    private BigDecimal outputTax;
    @ApiModelProperty("进项税")
    private BigDecimal inputTax;
    @ApiModelProperty("赠送乐富油比率")
    private BigDecimal sendLoveuRate;
    @ApiModelProperty("计算公式(必须要与实体属性名称一致)")
    private String formula;
}
