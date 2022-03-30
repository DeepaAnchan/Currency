package com.example.zuulApiGatewayServer;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean shouldFilter() {
		// Should this filter be executed or not.
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// Main filter logic
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("request -> {} request uri -> {}", request, request.getRequestURI());
		return null;
	}

	@Override
	public String filterType() {
		// Should this filter be executed pre/ post the request or only on error occurance.
		return "pre";
	}

	@Override
	public int filterOrder() {
		// If there are many filters, then order of the filter is set here.
		return 1;
	}

}
