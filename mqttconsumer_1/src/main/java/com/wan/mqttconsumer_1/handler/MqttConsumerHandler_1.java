package com.wan.mqttconsumer_1.handler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHandler;

/**
 * <p>PURPOSE:
 * <p>DESCRIPTION: 消息接收处理器
 * <p>CALLED BY: wanjian
 * <p>CREATE DATE: 2025/1/21
 * <p>UPDATE DATE: 2025/1/21
 * <p>UPDATE USER:
 * <p>HISTORY: 1.0
 *
 * @author wanjian
 * @version 1.0
 * @see
 * @since java 1.8
 */

@Configuration
public class MqttConsumerHandler_1 {

    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler handler() {
        return message -> {
            System.out.println("MqttConsumerHandler_1 Received message: " + message.getPayload());
        };
    }
}
