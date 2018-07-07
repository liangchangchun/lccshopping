package com.shopping.cloud.common.source;

public enum MessageHandlerEnum {
	WX_TEMP("01","微信模板消息"),SMS("02","手机短信消息");
	
	public String code;
	public String remark;
	
	MessageHandlerEnum(String code,String remark){
		this.code = code;
		this.remark = remark;
	}
	
	public static MessageHandlerEnum getHandle(String code){
		for (MessageHandlerEnum res : values()) {
			if(res.code.equals(code)){
				return res;
			}
		}
		return null;
	}
	
	public static String getRemark(String code){
		for (MessageHandlerEnum res : values()) {
			if(res.code.equals(code)){
				return res.remark;
			}
		}
		return null;
	}
	
}
