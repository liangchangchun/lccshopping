package com.shopping.cloud.common.helper;

import java.security.MessageDigest;

/**
 * <p>MD5加密</p>
 * @dateTime 2017年4月14日 下午3:59:12 
 * @author 陈麟  chenlin@lovego.com 
 * @version 1.00
 */
public class MD5 {
	/**
	 * 
	 * @dateTime 2017年4月14日 下午4:01:54 
	 * @author 陈麟  chenlin@lovego.com
	 * <p>MD5加密</p>
	 * @param s 需加密的字符串
	 * @return 加密后的字符串结果
	 */
	public final static String encode(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = s.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 
	 * @dateTime 2017年4月14日 下午4:01:54 
	 * @author 陈麟  chenlin@lovego.com
	 * <p>MD5加密</p>
	 * @param s 需加密的字符串
	 * @param encode 加密的encode类型
	 * @return 加密后的字符串结果
	 */
	public final static String encode(String s, String encode){
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            byte[] strTemp = s.getBytes(encode);
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

	public static void main(String[] args) {
		System.out.println(encode("123456"));
	}
}
