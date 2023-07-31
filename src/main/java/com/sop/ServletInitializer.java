package com.sop;

import javax.servlet.Servlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;


public class ServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ControleFinanceiroApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean<Servlet> dispatcherServlet() {
		DispatcherServlet dispatcherServlet = new DispatcherServlet();
		ServletRegistrationBean<Servlet> servletRegistrationBean = new ServletRegistrationBean<>((Servlet) dispatcherServlet, "/");

		servletRegistrationBean.setLoadOnStartup(1);
		return servletRegistrationBean;
	}
}