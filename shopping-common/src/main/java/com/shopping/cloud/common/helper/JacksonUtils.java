/**
 * 
 */
package com.shopping.cloud.common.helper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * <p>使用jackson包
 * 1.对象转json字符串
 * 2.字符串转化为对象
 * 3.字符串转化为ArrayList对象
 * 4.字符串转化为ArrayList的HashMap对象
 * 5.HashMap对象转对象</p>
 * @dateTime  2017年4月24日 下午6:41:59 
 * @author 刘勇  liuyong@lovego.com 
 * @version 1.00
 */
public class JacksonUtils {
	private final static ObjectMapper objectMapper = new ObjectMapper();

    private JacksonUtils() {

    }

    public static ObjectMapper getInstance() {

        return objectMapper;
    }

    /**
     * javaBean,list,array convert to json string
     */
    public static String obj2json(Object obj){
        try {
			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
    }

    /**
     * json string convert to javaBean
     * @throws IOException 
     * @throws JsonMappingException 
     * @throws JsonParseException 
     */
    public static <T> T json2pojo(String jsonStr, Class<T> clazz) throws Exception{
		return objectMapper.readValue(jsonStr, clazz);
    }

    /**
     * json string convert to map
     */
    public static Map<String, Object> json2map(String jsonStr) throws Exception{
		return objectMapper.readValue(jsonStr, new TypeReference<Map<String, Object>>() { });
    }

    /**
     * json string convert to map with javaBean
     */
    public static <T> Map<String, T> json2map(String jsonStr, Class<T> clazz) throws Exception{
		return objectMapper.readValue(jsonStr,new TypeReference<Map<String, T>>() {});
    }

    /**
     * json array string convert to list with javaBean
     */
    public static <T> List<T> json2list(String jsonArrayStr, Class<T> clazz)
            throws Exception {
        return objectMapper.readValue(jsonArrayStr,new TypeReference<List<T>>() {});
    }

    /**
     * map convert to javaBean
     */
    public static <T> T map2pojo(Map<String,Object> map, Class<T> clazz) {
        return objectMapper.convertValue(map, clazz);
    }
}
