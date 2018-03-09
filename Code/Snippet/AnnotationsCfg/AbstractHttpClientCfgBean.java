package com.sportradar.lms.config.beans;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data
public abstract class AbstractHttpClientCfgBean {

	private int maxThreadPerRoute;
	private int maxConnPoolSize;	
	private int connectionTimeOutInMillis;
	private int requestTimeOutInMillis;
	private int responseBufferSize;
	private int requestRetryMax;
	private long requestRetryIntervalMillis;
	
	public AbstractHttpClientCfgBean(
			@Value("#{hc.pool.maxThreadPerRoute:5}")int maxThreadPerRoute, 
			@Value("#{hc.pool.maxConnPoolSize:10}")int maxConnPoolSize,
			@Value("#{hc.pool.connectionTimeOutInMillis:10000}")int connectionTimeOutInMillis, 
			@Value("#{hc.pool.requestTimeOutInMillis:15}")int requestTimeOutInMillis,
			@Value("#{hc.pool.responseBufferSize:1024}")int responseBufferSize, 
			@Value("#{hc.pool.requestRetryMax:5}")int requestRetryMax,
			@Value("#{hc.pool.requestRetryIntervalMillis:10000}")long requestRetryIntervalMillis) {
		super();
		this.maxThreadPerRoute = maxThreadPerRoute;
		this.maxConnPoolSize = maxConnPoolSize;
		this.connectionTimeOutInMillis = connectionTimeOutInMillis;
		this.requestTimeOutInMillis = requestTimeOutInMillis;
		this.responseBufferSize = responseBufferSize;
		this.requestRetryMax = requestRetryMax;
		this.requestRetryIntervalMillis = requestRetryIntervalMillis;
	}
	
	
	
	
}
