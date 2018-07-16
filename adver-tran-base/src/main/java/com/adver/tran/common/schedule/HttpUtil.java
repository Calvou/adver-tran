package com.adver.tran.common.schedule;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Http工具类
 *
 * @author lvxh
 * @since V100R001C02
 * @version V100R001C02
 */
public abstract class HttpUtil {

	/**
	 * 用法 String url="http://192.168.2.181:8080/sic/app/login.action"; Map
	 * <String,String>map = new HashMap<>(); map.put("domainCode", "SA60");
	 * map.put("loginName", "root"); map.put("password", "rootroot");
	 * System.out.println(sendSms(url,map));
	 *
	 * @param url
	 *            String 请求地址
	 *
	 * @param list
	 *            键值对列表
	 *
	 * @return String 返回结果集
	 */
	public static String post(String url, List<NameValuePair> list) {
		HttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		String strResult = "";
		try {
			httpPost.addHeader("Content-type", "application/x-www-form-urlencoded");
			httpPost.setEntity(new UrlEncodedFormEntity(list, "UTF-8"));

			HttpResponse response = httpclient.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == 200) {
				strResult = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
			} else {
				strResult = String.valueOf(response.getStatusLine().getStatusCode());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strResult;
	}

	/**
	 * .以JSON方式(application/json)发送HTTP请求，并实时返回相应消息
	 *
	 * @param url
	 *            请求URL
	 * @param data
	 *            请求数据
	 * @return 请求相应
	 */
	public static String sendJSONPostImmediate(String url, String data) {
		return sendPost(url, data.replaceAll("\\\\u003d", "="), "application/json", 1000);
	}

	/**
	 * .以JSON方式(application/json)发送HTTP请求，并返回相应消息
	 *
	 * @param url
	 *            请求URL
	 * @param data
	 *            请求数据
	 * @return 请求相应
	 */
	public static String sendJSONPost(String url, String data, int timeout) {
		return sendPost(url, data.replaceAll("\\\\u003d", "="), "application/json", timeout);
	}

	/**
	 * .以FORM方式(application/x-www-form-urlencoded)发送HTTP请求，并返回相应消息
	 *
	 * @param url
	 *            请求URL
	 * @param data
	 *            请求数据
	 * @return 请求相应
	 */
	public static String sendFormPost(String url, String data, int timeout) {
		return sendPost(url, data.replaceAll("\\\\u003d", "="), "application/x-www-form-urlencoded", timeout);
	}

	/**
	 * .发送HTTP请求，并返回相应消息
	 *
	 * @param url
	 *            请求URL
	 * @param data
	 *            请求数据
	 * @param contentType
	 *            请求类型
	 * @param timeout
	 *            请求超时设置
	 * @return 请求相应
	 */
	private static String sendPost(String url, String data, String contentType, int timeout) {
		StringBuffer sbf = new StringBuffer();
		HttpURLConnection connection = null;
		try {
			connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(timeout);
			connection.setReadTimeout(timeout);
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestProperty("Content-Type", contentType);
			connection.connect();

			IOUtils.write(data, connection.getOutputStream(), StandardCharsets.UTF_8);

			for (String line : IOUtils.readLines(connection.getInputStream(), StandardCharsets.UTF_8)) {
				sbf.append(line);
			}
		} catch (Exception e) {
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
		return sbf.toString();
	}

	/**
	 * 用法 String url="http://192.168.2.181:8080/sic/app/login.action"; Map
	 * <String,String>map = new HashMap<>(); map.put("domainCode", "SA60");
	 * map.put("loginName", "root"); map.put("password", "rootroot");
	 * System.out.println(sendSms(url,map));
	 *
	 * @param the
	 *            type of the desired object
	 *
	 * @param url
	 *            String 请求地址
	 *
	 * @param list
	 *            键值对列表
	 *
	 * @param classOfT
	 *            classOfT 转换类型
	 *
	 * @return Object 返回结果集
	 */
	public static <T> T getPostObj(String url, List<NameValuePair> list, Class<T> classOfT) {
		String jsonString = post(url, list);
		if (StringUtils.isEmpty(jsonString)) {
			return null;
		}
		return null;
		// return JsonUtil.getObject(jsonString, classOfT);
	}
	
	
	
	/**
	 * ����
	 * 
	 * @param source
	 * @return
	 */
	public static String urlEncode(String source, String encode) {
		String result = source;
		try {
			result = java.net.URLEncoder.encode(source, encode);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "0";
		}
		return result;
	}

	public static String urlEncodeGBK(String source) {
		String result = source;
		try {
			result = java.net.URLEncoder.encode(source, "GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "0";
		}
		return result;
	}
}