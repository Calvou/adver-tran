package com.adver.tran.conf;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.adver.tran.web.filter.CorsFilter;


@Configuration
public class WebConf extends WebMvcConfigurerAdapter {

	@Bean
    public FilterRegistrationBean filterRegistrationCorsBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        CorsFilter corsFilter = new CorsFilter();
        filterRegistrationBean.setFilter(corsFilter);
        filterRegistrationBean.setEnabled(true);
        filterRegistrationBean.addInitParameter("allowOrigin", "*");
        filterRegistrationBean.addInitParameter("allowMethods", "GET,POST,PUT,DELETE,OPTIONS");
        filterRegistrationBean.addInitParameter("allowCredentials", "true");
        filterRegistrationBean.addInitParameter("allowHeaders", "Content-Type,X-Token,X-Username,x-auth-token,Authorization");
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }
	
}
