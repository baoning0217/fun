package com.vincce.fun.core;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
  Created By BaoNing On 2019年1月25日
*/
@Data
@Component
@ConfigurationProperties(prefix = "spring.rabbit.params")
public class RabbitmqProperties {
	
	private String exchangeName;
	
	private String routingKey;
	
	private String queueName;
	
}
