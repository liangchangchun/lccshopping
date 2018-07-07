/**
 * 
 */
package com.shopping.cloud.common.source;

/**
 * 系统类型
 * @author yuez
 * @date 2017-06-03 18:33
 */
public enum SystemTypeEnum {
	WEIXIN_SYSTEM("01","微信商城"),
	PC_MALL_SYSTEM("02","PC商城"),
	MARKET_SYSTEM("03","营销平台"),
	EXCHANGE_SYSTEM("04","积分兑换商城"),
	APP_MALL_SYSTEM("05","APP商城");
	
	public String code;
	public String remark;
	
	SystemTypeEnum(String code,String remark){
		this.code = code;
		this.remark = remark;
	}
	
	public static SystemTypeEnum getHandle(String code){
		for (SystemTypeEnum res : values()) {
			if(res.code.equals(code)){
				return res;
			}
		}
		return null;
	}
	
	public static String getRemark(String code){
		for (SystemTypeEnum res : values()) {
			if(res.code.equals(code)){
				return res.remark;
			}
		}
		return null;
	}
	
}
