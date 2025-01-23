package com.wan.mqtt.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.support.MessageBuilder;

/**
 * <p>PURPOSE:
 * <p>DESCRIPTION: mqtt消息网关
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
public class MqttProducerGateway {

    @Autowired
    private MqttPahoClientFactory mqttClientFactory;

    @Value("${mqtt.producer.defaultTopic}")
    private String defaultTopic;

    @Value("${mqtt.producer.async}")
    private boolean async;

    @Value("${mqtt.producer.qos}")
    private int qos;

    @Bean
    public MessageHandler mqttOutbound() {
        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler("producerClient", mqttClientFactory);
        messageHandler.setAsync(async); // 设置异步发送
        messageHandler.setDefaultTopic(defaultTopic); // 设置默认主题
        messageHandler.setDefaultQos(qos); // 设置默认QoS
        return messageHandler;
    }

    public void sendMessage(String payload) {
        Message<String> message = MessageBuilder.withPayload(payload)
                .setHeader(MqttHeaders.TOPIC, defaultTopic)
                .setHeader(MqttHeaders.QOS, qos)
                .build();
        mqttOutbound().handleMessage(message);
    }
}
