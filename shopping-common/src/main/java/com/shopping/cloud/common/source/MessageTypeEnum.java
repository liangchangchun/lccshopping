package com.shopping.cloud.common.source;

public enum MessageTypeEnum {
	SMS_COMMONS_CODE(MessageHandlerEnum.SMS,"00","通用验证码短信"),
	SMS_IDENTITY_AUTH(MessageHandlerEnum.SMS,"11","身份认证审核短信"),
	SMS_POINT_DEPOSIT_CODE(MessageHandlerEnum.SMS,"12","提现申请验证码短信"), 
	SMS_TRANFER_POINT_CODE(MessageHandlerEnum.SMS,"13","积分转赠验证码短信"), 
	SMS_UPGRADE_AGENT_SUCCESS_CODE(MessageHandlerEnum.SMS,"14","升级代理商成功短信"), 
	SMS_UPGRADE_CHANNEL_SUCCESS_CODE(MessageHandlerEnum.SMS,"15","升级(准)渠道商成功短信"), 
	SMS_UPGRADE_CHANNEL_FAIL_CODE(MessageHandlerEnum.SMS,"16","升级(准)渠道商失败短信"), 
	SMS_REGISTER_SUCCESS_CODE(MessageHandlerEnum.SMS,"17","代理商注册成功短信");
	
	public MessageHandlerEnum parent;
	public String code;
	public String remark;
	
	MessageTypeEnum(MessageHandlerEnum parent,String code,String remark){
		this.parent = parent;
		this.code = code;
		this.remark = remark;
	}
	
	public static MessageTypeEnum getHandle(String code){
		for (MessageTypeEnum res : MessageTypeEnum.values()) {
			if(res.code.equals(code)){
				return res;
			}
		}
		return null;
	}
	
	public static String getRemark(String code){
		for (MessageTypeEnum res : MessageTypeEnum.values()) {
			if(res.code.equals(code)){
				return res.remark;
			}
		}
		return null;
	}
	
}
