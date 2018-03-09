package com.sportradar.lms.config.beans;

import org.springframework.beans.factory.annotation.Value;


public class JetBrainsHttpCfgBean extends AbstractHttpClientCfgBean{


	
	public JetBrainsHttpCfgBean(
			@Value("#{hc.pool.maxThreadPerRoute:5}")int maxThreadPerRoute, 
			@Value("#{hc.pool.maxConnPoolSize:10}")int maxConnPoolSize,
			@Value("#{hc.pool.connectionTimeOutInMillis:10000}")int connectionTimeOutInMillis, 
			@Value("#{hc.pool.requestTimeOutInMillis:15}")int requestTimeOutInMillis,
			@Value("#{hc.pool.responseBufferSize:1024}")int responseBufferSize, 
			@Value("#{hc.pool.requestRetryMax:5}")int requestRetryMax,
			@Value("#{hc.pool.requestRetryIntervalMillis:10000}")long requestRetryIntervalMillis) {
		
		super(maxThreadPerRoute, maxConnPoolSize, connectionTimeOutInMillis,
				requestTimeOutInMillis, responseBufferSize, requestRetryMax,
				requestRetryIntervalMillis);
	}
}
