package com.alipay;



import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class applicationzhifubao {
	
	public static void main(String[] args) {
		SpringApplication.run(applicationzhifubao.class, args);
	}
	@Bean
	public MultipartConfigElement multipartConfigElement() {
	   MultipartConfigFactory factory = new MultipartConfigFactory();
	   //  单个数据大小
	   factory.setMaxFileSize("102400KB");
	   /// 总上传数据大小
	   factory.setMaxRequestSize("102400KB");
	   return factory.createMultipartConfig();
	}
	
}
