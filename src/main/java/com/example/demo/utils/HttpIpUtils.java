package com.example.demo.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author John Gao
 * @Description 这个工具类提供了一组用于获取客户端信息的公共方法
 */
public class HttpIpUtils {

	static final Logger logger = LoggerFactory.getLogger(HttpIpUtils.class);

	/**
	 * 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址;
	 * 
	 * @param request
	 *            hao_jp@suixingpay.com
	 * @return
	 * @throws IOException
	 */
	public final static String getClientIp(HttpServletRequest request) throws IOException {
		// 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址
		String ip = request.getHeader("X-Forwarded-For");
		if (logger.isInfoEnabled() && StringUtils.isNotBlank(ip)) {
			logger.info("getIpAddress(HttpServletRequest) - X-Forwarded-For - String ip=" + ip);
		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("Proxy-Client-IP");
				if (logger.isInfoEnabled() && StringUtils.isNotBlank(ip)) {
					logger.info("getIpAddress(HttpServletRequest) - Proxy-Client-IP - String ip="
							+ ip);
				}
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");
				if (logger.isInfoEnabled() && StringUtils.isNotBlank(ip)) {
					logger.info("getIpAddress(HttpServletRequest) - WL-Proxy-Client-IP - String ip="
							+ ip);
				}
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_CLIENT_IP");
				if (logger.isInfoEnabled() && StringUtils.isNotBlank(ip)) {
					logger.info("getIpAddress(HttpServletRequest) - HTTP_CLIENT_IP - String ip="
							+ ip);
				}
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_X_FORWARDED_FOR");
				if (logger.isInfoEnabled() && StringUtils.isNotBlank(ip)) {
					logger.info("getIpAddress(HttpServletRequest) - HTTP_X_FORWARDED_FOR - String ip="
							+ ip);
				}
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
				if (logger.isInfoEnabled() && StringUtils.isNotBlank(ip)) {
					logger.info("getIpAddress(HttpServletRequest) - getRemoteAddr - String ip="
							+ ip);
				}
			}
		} else if (ip.length() > 15) {
			String[] ips = ip.split(",");
			for (int index = 0; index < ips.length; index++) {
				String strIp = (String) ips[index];
				if (!("unknown".equalsIgnoreCase(strIp))) {
					ip = strIp;
					break;
				}
			}
		}
		return ip;
	}

}
