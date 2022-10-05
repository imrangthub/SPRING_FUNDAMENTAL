package com.imranmadbar;


import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Component
public class ApplicationFilter implements Filter {

  private Logger logger = LoggerFactory.getLogger(ApplicationFilter.class);

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {}

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
	 System.out.println("RequestID: "+((HttpServletRequest) request).getHeader("X-Request-ID"));
    try {
      MDC.put("X-Request-ID", ((HttpServletRequest) request).getHeader("X-Request-ID"));
      chain.doFilter(request, response);
    } catch (Exception e) {
      logger.info(e.getMessage());
    } finally {
      MDC.clear();
    }
  }

  @Override
  public void destroy() {}
}
