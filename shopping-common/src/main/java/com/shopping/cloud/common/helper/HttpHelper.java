package com.shopping.cloud.common.helper;

import com.google.common.collect.Lists;
import org.apache.commons.io.IOUtils;
import org.apache.http.*;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.*;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.lang.*;

/**
 * Created by linyue on 17/11/9.
 */
public class HttpHelper {

    private static CloseableHttpClient chc = HttpClients.createDefault();
    private static CloseableHttpClient sslchc = createSSLClientDefault();
    private static final Charset CHARSET = Charset.forName("UTF-8");

    //ssl client
    private static CloseableHttpClient createSSLClientDefault(){
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                //信任所有
                public boolean isTrusted(X509Certificate[] chain,String authType) throws CertificateException {
                    return true;
                }
            }).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
            return HttpClients.custom().setSSLSocketFactory(sslsf).build();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        return  HttpClients.createDefault();
    }


    //basic auth
    private static HttpClientContext createBasicAuthContext(String username, String password) {
        CredentialsProvider cp = new BasicCredentialsProvider();
        Credentials credentials = new UsernamePasswordCredentials(username, password);
        cp.setCredentials(AuthScope.ANY, credentials);
        HttpClientContext context = HttpClientContext.create();
        context.setCredentialsProvider(cp);
        return context;
    }


    private static String get(CloseableHttpClient chc,String url, List<NameValuePair> params){
        try {
            //get请求
            HttpGet get=new HttpGet();
            //设置参数
            if (null==params||params.size()==0){
                get.setURI(new URI(url));
            }else{
                get.setURI(new URI(url+"?"+ EntityUtils.toString(new UrlEncodedFormEntity(params,"UTF-8"))));
            }
            //发送请求
            HttpResponse response=chc.execute(get);
            //返回数据
            HttpEntity entity=response.getEntity();

            String result = EntityUtils.toString(entity,"utf-8");

            System.out.println("GET请求返回结果："+result);

            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * Http get 请求
     * @param url 请求地址
     * @param params 请求参数
     * @return
     */
    public static String httpGet(String url, List<NameValuePair> params){
        return get(chc,url,params);
    }

    /**
     * HTTP SSL GET 请求
     * @param url 请求地址
     * @param params 请求参数
     * @return
     */
    public static String httpSslGet(String url, List<NameValuePair> params){
        return get(sslchc,url,params);
    }

    /*
     * post提交
     * @return
     */
    public static String post(String url, List<NameValuePair> params){
        try {
            //post请求
            HttpPost post=new HttpPost(url);

            //设置参数
            post.setEntity(new UrlEncodedFormEntity(params));

            //发送请求
            HttpResponse response=chc.execute(post);
            //返回数据
            HttpEntity entity=response.getEntity();

            String result = EntityUtils.toString(entity,"utf-8");

            System.out.println("POST请求返回结果："+result);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    /*
    * post提交
    * @return
    */
    public static String postJSON(String url, String json){
        try {
            //post请求
            HttpPost post=new HttpPost(url);

            post.setHeader("Content-Type","application/json;charset=utf-8");

            //设置参数
            post.setEntity(new StringEntity(json, Charset.forName("UTF-8")));

            //发送请求
            HttpResponse response=chc.execute(post);
            //返回数据
            HttpEntity entity=response.getEntity();

            String result = EntityUtils.toString(entity,"utf-8");

            System.out.println("POST请求返回结果："+result);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /*
     * post提交
     * @return
     */
    public static String post(String url, String params){
        try {
            //post请求
            HttpPost post=new HttpPost(url);

            //设置参数
            post.setEntity(new StringEntity(params,"utf-8"));
            //发送请求
            HttpResponse response=chc.execute(post);
            //返回数据
            HttpEntity entity=response.getEntity();

            String result = EntityUtils.toString(entity,"utf-8");

            System.out.println("POST请求返回结果："+result);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /*
     * post提交
     * @return
     */
    public static String SSLPost(String url, List<NameValuePair> params){
        try {
            //post请求
            HttpPost post=new HttpPost(url);
            //设置参数
            post.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
            //发送请求
            HttpResponse response=sslchc.execute(post);
            //返回数据
            HttpEntity entity=response.getEntity();

            String result = EntityUtils.toString(entity,"utf-8");

            System.out.println("POST请求返回结果："+result);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    /*
     * post提交
     * @return
     */
    public static String SSLPost(String url, String entityStr){
        try {
            //post请求
            HttpPost post=new HttpPost(url);
            //设置参数
            post.setEntity(new StringEntity(entityStr, "utf-8"));
            //发送请求
            HttpResponse response=sslchc.execute(post);
            //返回数据
            HttpEntity entity=response.getEntity();

            String result = EntityUtils.toString(entity,"utf-8");

            System.out.println("POST请求返回结果："+result);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * post auth 提交
     * @param url
     * @param params
     * @param userName
     * @param password
     * @return
     */
    public static String authPost(String url,List<NameValuePair> params,String userName,String password){
        try {
            HttpClientContext context = createBasicAuthContext(userName,password);
            //post请求
            HttpPost httpPost = new HttpPost(url);

            //设置参数
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            //发送请求
            HttpResponse response = chc.execute(httpPost,context);
            //返回数据
            HttpEntity entity=response.getEntity();

            String result = EntityUtils.toString(entity,"utf-8");

            System.out.println("AUTH POST请求返回结果："+result);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String postRequest(String url, Map<String, String> params) throws Exception {
        CloseableHttpClient httpClient = getHttpClient();
        List<NameValuePair> list = new ArrayList<>();
        for(Map.Entry<String, String> param : params.entrySet()){
            list.add(new BasicNameValuePair(param.getKey(), param.getValue()));
        }
        HttpPost httpPost = new HttpPost(url);
        HttpEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list,CHARSET);
        httpPost.setEntity(urlEncodedFormEntity);
        CloseableHttpResponse response = httpClient.execute(httpPost);

        return responseToString(response, CHARSET);
    }
    public static CloseableHttpClient getHttpClient() {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        return httpClientBuilder.build();
    }

    /**
     * 响应结果转String
     * @param response 响应
     * @param encoding 编码
     * @return 响应文本
     * @throws IOException 响应流异常
     */
    public static String responseToString(CloseableHttpResponse response, Charset encoding) throws IOException {
        HttpEntity entity = response.getEntity();
        InputStream content = entity.getContent();
        String contentStr = IOUtils.toString(content, encoding);
        content.close();
        response.close();
        return contentStr;
    }

    public static void main(String[] args) {

        /*List<NameValuePair> params = Lists.newArrayList();
        params.add(new BasicNameValuePair("schoolId", "81"));
        params.add(new BasicNameValuePair("gradeCode", "2015"));
        params.add(new BasicNameValuePair("courseCode", ""));
        params.add(new BasicNameValuePair("clazzId", "96499070125740583"));

        authPost("http://zsyapi.dev.xueping.com/rest/school/sync", params, "test", "123456");
*/

    }



}
