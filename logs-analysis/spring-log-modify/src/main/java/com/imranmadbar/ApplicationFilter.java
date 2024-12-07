package com.imranmadbar;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Component
public class ApplicationFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(ApplicationFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			MDC.put("rmAddr", httpRequest.getRemoteAddr());
			MDC.put("reqUrl", httpRequest.getRequestURI());
			MDC.put("reqMth", httpRequest.getMethod());
			MDC.put("usrAgnt", httpRequest.getHeader("User-Agent"));
			MDC.put("httpV", httpRequest.getProtocol());
			MDC.put("X-Request-ID", ((HttpServletRequest) request).getHeader("X-Request-ID"));
			chain.doFilter(request, response);
		} catch (Exception e) {
			logger.info(e.getMessage());
		} finally {
			MDC.clear();
		}
	}

	@Override
	public void destroy() {
	}
}
