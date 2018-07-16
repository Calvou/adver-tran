package com.adver.tran.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adver.tran.common.exception.BusinessException;

import net.sf.json.JSONObject;

public class HttpsUtil {
	private static Logger log = LoggerFactory.getLogger(HttpsUtil.class);
	
	private static RequestConfig requestConfig;
	private static final int MAX_TIMEOUT = 60000;//30s
    //private static final String APPLICATION_JSON = "application/json";
    private static final String APPLICATION_JSON = "application/json";
    private static final String CONTENT_ENCODING = "UTF-8";
    
    //初始化
  	//private static Registry<ConnectionSocketFactory> socketFactoryRegistry;
  	//创建ConnectionManager，添加Connection配置信息
  	//private static PoolingHttpClientConnectionManager connectionManager;
  	//private static CloseableHttpClient httpClient;  	
  	private static HttpClient httpClient;
  	//private static SSLConnectionSocketFactory socketFactory;
    
  	//使用SSL方式其实现不在此方法
	/*static {
        enabledSSL();
  		socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create().register("https", socketFactory).build();
  		connectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
  		requestConfig = RequestConfig.custom().setSocketTimeout(MAX_TIMEOUT).setConnectTimeout(MAX_TIMEOUT).build();
  		connectionManager.setMaxTotal(100);
  		httpClient = HttpClients.custom().setConnectionManager(connectionManager).setDefaultRequestConfig(requestConfig).build();
    }*/

  	static{
  		if(CheckParam.isNull(httpClient)){
  			try {
				httpClient = new SSLClient();
			} catch (Exception e) {
				log.debug(BaseCode.E_1001009999," 创建HttpsClient失败 : " +e);
				new BusinessException(BaseCode.E_1001009999,"创建HttpsClient失败");
			}
  		}
  	}
  	
  	/*public static HttpClient getHttpClient() throws BusinessException{
  		try {
  			HttpClient httpClient1 = new SSLClient();
  			return httpClient1;
		} catch (Exception e) {
			log.debug(BaseCode.E_1001009999," 创建连接失败 : " +e);
			new BusinessException(BaseCode.E_1001009999,"创建连接失败");
		}
		return null;		
  	}*/
	
	@SuppressWarnings("unchecked")
	public static Map<String,Object> post(Map<String,String> paramMap,Map<String,String> fileParam,String url){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		//String tranType = paramMap.get("tranType");
		log.debug("准备向" + url + "发送请求，获取响应反回到前端");
		HttpPost httpPost = null;
		log.debug("准备请求");
		try {
			httpPost = new HttpPost(url);
			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			builder.setCharset(StandardCharsets.UTF_8);
			//向post请求中加入各种参数
			for(Map.Entry<String, String> entry : paramMap.entrySet()){
				log.debug("添加参数key:{},value:{}",entry.getKey(),entry.getValue());
				ContentType contentType = ContentType.create("application/json",StandardCharsets.UTF_8);
				StringBody stringBody = new StringBody(entry.getValue(),contentType);
				builder.addPart(entry.getKey(), stringBody);
			}
			
			//向post请求中加入文件参数
			for(Map.Entry<String, String> entry : fileParam.entrySet()){
				log.debug("添加参数key:{},val:{}",entry.getKey(),entry.getValue());
				builder.addPart(entry.getKey(), new FileBody( new File(entry.getValue())));
			}
			
			HttpEntity entity = builder.build();
			httpPost.setEntity(entity);
			log.debug("准备发送");
			HttpClient httpClientn = new SSLClient();
			HttpResponse tmpResponse = httpClientn.execute(httpPost);
			if (tmpResponse != null) {
				log.debug("收到响应");
				HttpEntity resEntity = tmpResponse.getEntity();
				
				if (resEntity != null) {
					log.debug("读取输出");
					//读取输出
					ByteArrayOutputStream bos = new ByteArrayOutputStream();
					
					byte[] buffer = new byte[1024];
					int read = resEntity.getContent().read(buffer);
					while(read >= 0){
						
						//等于0的情况，是数据流没有结束，但是
						//因为网络问题，暂时还没有读到数据
						//这种情况下，100毫秒后再去读
						if(read == 0){
							Thread.sleep(100);
						}
						
						bos.write(buffer,0,read);
						read = resEntity.getContent().read(buffer);
					}
					
					String resultStr = new String(bos.toByteArray());
					log.debug("读取输出结果：" + resultStr);
					JSONObject json = JSONObject.fromObject(resultStr);
					log.debug("生成json" + json);
					
					resultMap.putAll(json);
					resultMap.put("result", "0");
					resultMap.put("message", "ok");
					log.debug("返回数据" + resultMap);
					return resultMap;
				}
			}
			log.debug("响应无数据");
			resultMap.put("result", BaseCode.E_1001009999);
			resultMap.put("message", "发送请求到" + url + "失败,响应无数据");
			return resultMap;
		} catch (Exception e) {
			log.debug("发送到" + url + "异常");
			e.printStackTrace();
			resultMap.put("result", BaseCode.E_1001009999);
			resultMap.put("message", "服务繁忙");
			return resultMap;
		}finally{
			httpPost.releaseConnection();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String,Object> postStream(Map<String,String> paramMap, String filename, InputStream in, String url){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		//String tranType = paramMap.get("tranType");
		log.debug("准备向" + url + "发送请求，获取响应反回到前端");
		HttpPost httpPost = null;
		log.debug("准备请求");
		try {
			httpPost = new HttpPost(url);
			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			builder.setCharset(StandardCharsets.UTF_8);
			//向post请求中加入各种参数
			for(Map.Entry<String, String> entry : paramMap.entrySet()){
				log.debug("添加参数key:{},value:{}",entry.getKey(),entry.getValue());
				ContentType contentType = ContentType.create("application/json",StandardCharsets.UTF_8);
				StringBody stringBody = new StringBody(entry.getValue(),contentType);
				builder.addPart(entry.getKey(), stringBody);
			}
			
			//向post请求中加入文件参数 
			builder.addBinaryBody(filename, in);
			/*for(Map.Entry<String, String> entry : fileParam.entrySet()){
				log.debug("添加参数key:{},val:{}",entry.getKey(),entry.getValue());
				builder.addPart(entry.getKey(), new FileBody( new File(entry.getValue())));
			}*/
			
			HttpEntity entity = builder.build();
			httpPost.setEntity(entity);
			log.debug("准备发送");
			httpClient = new SSLClient();
			HttpResponse tmpResponse = httpClient.execute(httpPost);
			if (tmpResponse != null) {
				log.debug("收到响应");
				HttpEntity resEntity = tmpResponse.getEntity();
				
				if (resEntity != null) {
					log.debug("读取输出");
					//读取输出
					ByteArrayOutputStream bos = new ByteArrayOutputStream();
					
					byte[] buffer = new byte[1024];
					int read = resEntity.getContent().read(buffer);
					while(read >= 0){
						
						//等于0的情况，是数据流没有结束，但是
						//因为网络问题，暂时还没有读到数据
						//这种情况下，100毫秒后再去读
						if(read == 0){
							Thread.sleep(100);
						}
						
						bos.write(buffer,0,read);
						read = resEntity.getContent().read(buffer);
					}
					
					String resultStr = new String(bos.toByteArray());
					log.debug("读取输出结果：" + resultStr);
					JSONObject json = JSONObject.fromObject(resultStr);
					log.debug("生成json" + json);
					
					resultMap.putAll(json);
					resultMap.put("result", "0");
					resultMap.put("message", "ok");
					log.debug("返回数据" + resultMap);
					return resultMap;
				}
			}
			log.debug("响应无数据");
			resultMap.put("result", BaseCode.E_1001009999);
			resultMap.put("message", "发送请求到" + url + "失败,响应无数据");
			return resultMap;
		} catch (Exception e) {
			log.debug("发送到" + url + "异常");
			e.printStackTrace();
			resultMap.put("result", BaseCode.E_1001009999);
			resultMap.put("message", "服务繁忙");
			return resultMap;
		}finally{
			httpPost.releaseConnection();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String,Object> postJson(String url,String json){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		//String tranType = paramMap.get("tranType");
		log.debug("准备向" + url + "发送请求，请求内容为：" + json);
		HttpPost httpPost = null;
//		log.debug("准备请求");
		try {
			httpPost = new HttpPost(url);
			//https://101.132.222.202/api/recognize/faceCode	
			ContentType contentType = ContentType.create("application/json",StandardCharsets.UTF_8);
			HttpEntity entity = new StringEntity(json, contentType);
			httpPost.setEntity(entity);
//			log.debug("准备发送");
			httpClient = new SSLClient();
			HttpResponse tmpResponse = httpClient.execute(httpPost);
			if (tmpResponse != null) {
//				log.debug("收到响应");
				HttpEntity resEntity = tmpResponse.getEntity();
				
				if (resEntity != null) {
//					log.debug("读取输出");
					//读取输出
					ByteArrayOutputStream bos = new ByteArrayOutputStream();
					
					byte[] buffer = new byte[1024];
					int read = resEntity.getContent().read(buffer);
					while(read >= 0){
						
						//等于0的情况，是数据流没有结束，但是
						//因为网络问题，暂时还没有读到数据
						//这种情况下，100毫秒后再去读
						if(read == 0){
							Thread.sleep(100);
						}
						
						bos.write(buffer,0,read);
						read = resEntity.getContent().read(buffer);
					}
					
					String resultStr = new String(bos.toByteArray());
					log.debug("读取输出结果：" + resultStr);
					if (!CheckParam.isNull(resultStr)) {
						JSONObject resJson = JSONObject.fromObject(resultStr);
						log.debug("生成json" + resJson);
						resultMap.putAll(resJson);
						log.debug("返回数据" + resultMap);
					}
					return resultMap;
				}
			}
			log.debug("发送请求到" + url + "失败,响应无数据");
			throw new BusinessException(BaseCode.E_1001009999,"无响应数据");
		} catch (Exception e) {
			log.debug("发送到" + url + "异常");
			e.printStackTrace();
			throw new BusinessException(BaseCode.E_1001009999,"服务繁忙");
		}finally{
			httpPost.releaseConnection();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static String postJsonString(String url,String json){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		//String tranType = paramMap.get("tranType");
		log.debug("准备向" + url + "发送请求，请求内容为：" + json);
		HttpPost httpPost = null;
//		log.debug("准备请求");
		try {
			httpPost = new HttpPost(url);
			//https://101.132.222.202/api/recognize/faceCode	
			ContentType contentType = ContentType.create("application/json",StandardCharsets.UTF_8);
			HttpEntity entity = new StringEntity(json, contentType);
			httpPost.setEntity(entity);
//			log.debug("准备发送");
			httpClient = new SSLClient();
			HttpResponse tmpResponse = httpClient.execute(httpPost);
			if (tmpResponse != null) {
//				log.debug("收到响应");
				HttpEntity resEntity = tmpResponse.getEntity();
				
				if (resEntity != null) {
//					log.debug("读取输出");
					//读取输出
					ByteArrayOutputStream bos = new ByteArrayOutputStream();
					
					byte[] buffer = new byte[1024];
					int read = resEntity.getContent().read(buffer);
					while(read >= 0){
						
						//等于0的情况，是数据流没有结束，但是
						//因为网络问题，暂时还没有读到数据
						//这种情况下，100毫秒后再去读
						if(read == 0){
							Thread.sleep(100);
						}
						
						bos.write(buffer,0,read);
						read = resEntity.getContent().read(buffer);
					}
					
					String resultStr = new String(bos.toByteArray());
					log.debug("读取输出结果：" + resultStr);
					/*if (!CheckParam.isNull(resultStr)) {
						JSONObject resJson = JSONObject.fromObject(resultStr);
						log.debug("生成json" + resJson);
						resultMap.putAll(resJson);
						log.debug("返回数据" + resultMap);
					}*/
					return resultStr;
				}
			}
			log.debug("发送请求到" + url + "失败,响应无数据");
			throw new BusinessException(BaseCode.E_1001009999,"无响应数据");
		} catch (Exception e) {
			log.debug("发送到" + url + "异常");
			e.printStackTrace();
			throw new BusinessException(BaseCode.E_1001009999,"服务繁忙");
		}finally{
			httpPost.releaseConnection();
		}
	}
	
	public static HttpResponse get(String url) throws Exception{
		HttpGet httpGet = new HttpGet(url);
		HttpResponse response = null;
		try {
			HttpClient httpClientn = new SSLClient();
			response = httpClientn.execute(httpGet);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("", "资源访问异常！");
		}finally{
			//httpGet.releaseConnection();
		}
		return response;
	}	
	
	private static TrustManager trustManager = new X509TrustManager() {
		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}
		
		@Override
		public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
				throws CertificateException {			
		}
		
		@Override
		public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
				throws CertificateException {			
		}
	};
	
	private static HostnameVerifier hnv = new HostnameVerifier() {
	    public boolean verify(String hostname, SSLSession session) {
	        System.out.println("hostname:======:" + hostname);
	        return true;
	    }
	};
	
	private static void enabledSSL(){
		try{
			SSLContext context = SSLContext.getInstance("TLS");
			context.init(null, new TrustManager[] {trustManager}, null);
			//socketFactory = new SSLConnectionSocketFactory(context,NoopHostnameVerifier.INSTANCE);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*public static String getFileName(HttpResponse response) {
		Header contentHeader = response.getFirstHeader("Content-Disposition");
		String filename = null;
		if (contentHeader != null) {
			HeaderElement[] values = contentHeader.getElements();
			if (values.length == 1) {
				NameValuePair param = values[0].getParameterByName("filename");
				if (param != null) {
					try {
						//filename = new String(param.getValue().toString().getBytes(), "utf-8");
						//filename=URLDecoder.decode(param.getValue(),"utf-8");
						filename = param.getValue();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return filename;
	}*/
	
	
	
}
