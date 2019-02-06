package org.tiandy.KFWebService.sendMsg.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tiandy.KFWebService.sendMsg.entity.Config.B2BUrlEntity;

@Configuration
public class B2BConfig {
	@Bean
	@ConfigurationProperties(prefix="b2b")
	public B2BUrlEntity b2BUrlEntity(){
		return new B2BUrlEntity();
	}
}
