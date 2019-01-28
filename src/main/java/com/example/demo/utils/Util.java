package com.example.demo.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Util {

	private static final Logger LOG = LoggerFactory.getLogger(Util.class);

	public static String getUuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * 读取配置文件
	 *
	 * @throws
	 */
//	public static String getProValue(String key) throws SysException {
//		Locale locale = Locale.getDefault();
//		ResourceBundle bundle;
//		try {
//			bundle = ResourceBundle.getBundle("config", locale);
//		} catch (Exception e) {
//			throw new SystemException(ExceptionEnum.POS29999);
//		}
//		return bundle.getString(key);
//	}

	public static String getFixation(String str, int n) {
		if(null == str)str = "其它";
		int c = 0;
		try {
			c = str.getBytes("GBK").length;
		} catch (UnsupportedEncodingException e) {
		}
		if (n <= c)
			return str;
		int l = n - c;
		StringBuffer result = new StringBuffer(str);
		for (int i = 0; i < l; i++)
			result.append(" ");
		return result.toString();
	}

	/**
	 * 浮点型数据比较大小
	 * @param args1
	 * @param args2
	 * @return
	 */
	public static int compareFloat(String args1, String args2){
		int result = new BigDecimal(args1).compareTo(new BigDecimal(args2));
		return result;
	}

	public static int getIntervalDays(String start,String end) throws ParseException{

		//格式化字符串为日期
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date startday = format.parse(start);
		Date endday = format.parse(end);

		//判断日期前后
		if(startday.after(endday)){
			Date cal=startday;
			startday=endday;
			endday=cal;
		}
		//分别得到两个时间的毫秒数
		long sl=startday.getTime();
		long el=endday.getTime();

		//取得间隔毫秒数
		long ei=el-sl;

		//根据毫秒数计算间隔天数
		return  (int) (ei/(1000*60*60*24));
	}

	/**
	 * 格式化字符串，不够位数的补零
	 * @param str
	 * @param strLength
	 * @return
	 */
	public static String addZeroForNum(String str, int strLength) {
		int strLen = str.length();
		StringBuffer sb = null;
		while (strLen < strLength) {
			sb = new StringBuffer();
			// sb.append("0").append(str);// 左(前)补0
			sb.append(str).append("0");//右(后)补0
			str = sb.toString();
			strLen = str.length();
		}
		return str;
	}

	/**
	 * 去掉字符串中的换行、回车、制表符
	 * @param str
	 * @return
	 */
	public static String replaceBlank(String str) {
		String dest = "";
		if (str!=null) {
			Pattern p = Pattern.compile("\\t|\\r|\\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}

	/**
	 * 去掉字符串中连续出现两次的空格
	 * @param str
	 * @return
	 */
	public static String replace2Blank(String str) {
		String dest = "";
		if (str!=null) {
			Pattern p = Pattern.compile("\\s{2}");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}

	public static String createF63(String s, String bkName){
		if(null == bkName)bkName = "其它";
		StringBuffer sb = new StringBuffer(StringUtils.rightPad(s, 63));
		sb.append(getFixation(bkName, 30));
		sb.append(StringUtils.rightPad("48360000", 30));
		return sb.toString();
	}
//
//	public static String doGet(String http_url, boolean isProxy) {
//		HttpMethod method = null;
//		try {
//			URI uri = new URI(http_url, true);
//			HttpClient client = new HttpClient();
//			HostConfiguration hcfg = new HostConfiguration();
//			hcfg.setHost(uri);
//			client.setHostConfiguration(hcfg);
//			// 参数验证
//			client.getParams().setAuthenticationPreemptive(true);
//			// GET请求方式
//			method = new GetMethod(http_url);
//			client.executeMethod(method);
//			return method.getResponseBodyAsString();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	public static String doPost(String http_url, Map<String, String> paramaters,
//								boolean isProxy) {
//		PostMethod method = null;
//		try {
//			URI uri = new URI(http_url, true);
//			HttpClient client = new HttpClient();
//			HostConfiguration cf = new HostConfiguration();
//			cf.setHost(uri);
//			client.setHostConfiguration(cf);
//			client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
//			client.getParams().setAuthenticationPreemptive(true);
//			client.getParams().setContentCharset("UTF-8");
//			method = new PostMethod(http_url);
//			// 添加参数
//			if (paramaters != null) {
//				Iterator<Entry<String, String>> its = paramaters.entrySet()
//						.iterator();
//				while (its.hasNext()) {
//					Entry<String, String> e = its.next();
//					method.addParameter(e.getKey(), e.getValue());
//				}
//			}
//			client.executeMethod(method);
//			// 输出返回的信息
//			return method.getResponseBodyAsString();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			// 释放连接
//			if (method != null)
//				method.releaseConnection();
//		}
//		return null;
//	}

	public static String connectPostUrl(String url, Map<String, String> paramaters) {
		//LOG.info(paramaters.toString()+"yes"+paramaters.get("resCode")+"hello"+paramaters.get("orderNo"));
		String jObj = "";
		HttpPost httppost = null;
		CloseableHttpResponse resp = null;
		try {
			CloseableHttpClient httpclient = HttpClientUtil.getHttpClient();
			httppost = new HttpPost(url);
			RequestConfig requestConfig = RequestConfig.custom()
					.setConnectTimeout(2000).setConnectionRequestTimeout(2000)
					.setSocketTimeout(5000).build();
			httppost.setConfig(requestConfig);
			List<NameValuePair> formparams = new LinkedList<NameValuePair>();
			if (paramaters != null) {
				Iterator<Entry<String, String>> its = paramaters.entrySet().iterator();
				while (its.hasNext()) {
					Entry<String, String> e = its.next();
					formparams.add(new BasicNameValuePair(e.getKey(), e.getValue()));
				}
			}
			httppost.setEntity(new UrlEncodedFormEntity(formparams, "UTF-8"));
			resp = httpclient.execute(httppost);
			LOG.info("推送请求状态码:{}",resp.getStatusLine().getStatusCode());
			HttpEntity entity = resp.getEntity();
			String jsonString = EntityUtils.toString(entity, "UTF-8");
			jObj = jsonString;
		} catch (Exception e) {
			LOG.info(e.getMessage());
		} finally {
			if (resp != null) {
				try {
					resp.close();
				} catch (IOException e) {
					LOG.info("关闭HTTPCLIENT输出流异常", e);
				}
			}
			if (httppost != null) {
				httppost.releaseConnection();
			}
		}
		return jObj;
	}

}

