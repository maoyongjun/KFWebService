package org.tiandy.KFWebService.sendMsg;

import java.io.IOException;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("org.tiandy.KFWebService.sendMsg.dao")
public class MyApplication extends SpringBootServletInitializer{
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MyApplication.class); 
	}
	
	public static void main(String[] args) throws IOException {
		SpringApplication.run(MyApplication.class, args);
	}
}
	