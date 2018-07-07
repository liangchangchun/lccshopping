package com.shopping.cloud.common.equation;

import java.math.BigDecimal;

/**
 * @author 邓双雄 dengsx@lovego.com
 * @dateTime Created in 10:47 2017/11/17
 */
public class EquationGross {
    /**
     * 获取毛利值
     *
     * @param price         售价
     * @param redPackage    红包抵扣
     * @param bid           进价
     * @param outputTax     销项税
     * @param poolRoportion 资金池比例（乐富油比例）
     * @param inputTax      进项税
     * @return
     */
    public static BigDecimal getGross(BigDecimal salePrice, BigDecimal redPackage, BigDecimal costPrice, BigDecimal outputTax, BigDecimal poolRoportion, BigDecimal inputTax) {
        if (salePrice==null){
            salePrice=new BigDecimal("0.0");
        }
        if (redPackage==null){
            redPackage=new BigDecimal("0.0");
        }
        if (costPrice==null){
            costPrice=new BigDecimal("0.0");
        }
        if (outputTax==null){
            outputTax=new BigDecimal("0.0");
        }
        if (poolRoportion==null){
            poolRoportion=new BigDecimal("0.0");
        }
        if (inputTax==null){
            inputTax=new BigDecimal("0.0");
        }

        //售价*（积分池等级+运营成本占比0.06）
        BigDecimal arg1 = salePrice.multiply(new BigDecimal(0.06).add(poolRoportion));
        //[(销售净额-采购价)/(1+销项税)] *销项税

        //[售价*销项税率/(1+销项税)]
        BigDecimal arg2 = ((salePrice.multiply(outputTax)).divide((new BigDecimal(1.0).add(outputTax)),4,BigDecimal.ROUND_CEILING));

        //[进价*进项税率/(1+进项税)]
        BigDecimal arg3 = ((costPrice.multiply(inputTax)).divide(inputTax.add(new BigDecimal(1.0)),4,BigDecimal.ROUND_CEILING));

        BigDecimal gross1 = salePrice.subtract(costPrice).subtract(arg1).subtract(arg2.subtract(arg3));
        BigDecimal gross =gross1.setScale(4,BigDecimal.ROUND_CEILING);

        return gross;
    }

    /**
     * 获取毛利率
     *
     * @param price         售价
     * @param redPackage    红包抵扣
     * @param bid           进价
     * @param outputTax     销项税
     * @param poolRoportion 资金池比例（乐富油比例）
     * @param inputTax      进项税
     * @return
     */
    public static BigDecimal getpGross(BigDecimal price, BigDecimal redPackage, BigDecimal bid, BigDecimal outputTax, BigDecimal poolRoportion, BigDecimal inputTax) {
        if (price==null){
            price=new BigDecimal("0.0");
        }
        if (redPackage==null){
            redPackage=new BigDecimal("0.0");
        }
        if (bid==null){
            bid=new BigDecimal("0.0");
        }
        if (outputTax==null){
            outputTax=new BigDecimal("0.0");
        }
        if (poolRoportion==null){
            poolRoportion=new BigDecimal("0.0");
        }
        if (inputTax==null){
            inputTax=new BigDecimal("0.0");
        }
        BigDecimal gross = getGross(price, redPackage, bid, outputTax, poolRoportion, inputTax);
        //毛利率=毛利额/商品单价
        BigDecimal pGross=null;
        if (price.compareTo(BigDecimal.ZERO)!=0){
            pGross = gross.divide(price, 4, BigDecimal.ROUND_CEILING);
        }
        return pGross;
    }





}
