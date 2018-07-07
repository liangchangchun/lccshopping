package com.shopping.cloud.common.helper;

import com.qiniu.util.Auth;

/**
 * 描述:
 * 七牛云存储工具类
 *
 * @author 34861
 * @create 2017-11-13 14:38
 */
public class QiNiuUtils {

    private String accessKey;

    private String secretKey;

    private String bucketName;

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public QiNiuUtils(String accessKey,String secretKey,String bucketName) {
        this.bucketName = bucketName;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    /**
     * 获取七牛上传token
     * @param accessKey
     * @param secretKey
     * @param bucketName
     * @return
     */
    public static String getUpToken(String accessKey,String secretKey,String bucketName){
        Auth auth = Auth.create(accessKey,secretKey);
        return auth.uploadToken(bucketName);
    }
}
