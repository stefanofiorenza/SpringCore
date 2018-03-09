package com.sportradar.lms.config;

import org.springframework.context.annotation.Configuration;

import com.sportradar.lms.components.LicenseServiceProxy;
import com.sportradar.lms.components.QueryService;

@Configuration
public class AbstractLmsCommonContext implements LmsCommonContext{

	
	
	
	
	@Override
	public LicenseServiceProxy office365LicenceProxy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LicenseServiceProxy gitlabLicenceProxy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueryService queryService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LicenseServiceProxy jetbrainsLicenceProxy() {
		// TODO Auto-generated method stub
		return null;
	}

}
