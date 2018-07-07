package com.shopping.cloud.common.utils;

import com.shopping.cloud.common.page.PageList;

import java.io.*;
import java.util.ArrayList;

/**
 * 描述:
 * 序列化工具类
 *
 * @author 34861
 * @create 2017-11-23 3:14
 */
public class SerializeUtil {

    /**
     * 序列化
     *
     * @param value
     * @return
     */
    public static byte[] serialize(Object value) {
        if (value == null) {
            throw new NullPointerException("Can't serialize null");
        }
        byte[] rv = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream os = null;
        try {
            bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            os.writeObject(value);
            os.close();
            bos.close();
            rv = bos.toByteArray();
        } catch (IOException e) {
            throw new IllegalArgumentException("Non-serializable object", e);
        } finally {
            try {
                if (os != null)
                    os.close();
                if (bos != null)
                    bos.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return rv;
    }

    /**
     * 反序列化
     *
     * @param in
     * @return
     */
    public static String deserialize(byte[] in) {
        Object rv = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream is = null;
        try {
            if (in != null) {
                bis = new ByteArrayInputStream(in);
                is = new ObjectInputStream(bis);
                rv = is.readObject();
                is.close();
                bis.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
                if (bis != null)
                    bis.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return rv != null ? rv.toString() : null;
    }
 
}
