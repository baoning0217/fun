package com.vincce.fun.service;

import java.io.IOException;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rabbitmq.client.ConfirmCallback;

/**
  Created By BaoNing On 2019年1月25日
*/
@Service
public class RabbitMqService implements ConfirmCallback{
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	/**
	 * 发送消息
	 * @param msg
	 */
	public void sendMsg(String msg) {
		
	}

	@Override
	public void handle(long arg0, boolean arg1) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	

}
