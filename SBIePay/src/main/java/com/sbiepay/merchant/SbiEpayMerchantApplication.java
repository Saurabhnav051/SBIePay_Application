package com.sbiepay.merchant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//import com.DateCalculator.controller.AppController1;





@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class SbiEpayMerchantApplication extends SpringBootServletInitializer implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(SbiEpayMerchantApplication.class, args);
		/*
		 * AppController1 appContoller1=new AppController1();
		 * 
		 * System.out.println(appContoller1.getSum(10, 20));
		 */
	}
	
	public void addViewControllers(ViewControllerRegistry registry) {
		// registry.addViewController("/home").setViewName("baedal-home");
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/add").setViewName("add");
		
		registry.addViewController("/transaction6").setViewName("transaction6");

	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SbiEpayMerchantApplication.class);
	} 


}
