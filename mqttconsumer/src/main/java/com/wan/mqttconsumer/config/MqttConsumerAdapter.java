package com.wan.mqttconsumer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.messaging.MessageChannel;

/**
 * <p>PURPOSE:
 * <p>DESCRIPTION: mqtt消息适配通道
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
public class MqttConsumerAdapter {

    @Autowired
    private MqttPahoClientFactory mqttClientFactory;

    @Value("${mqtt.consumer.defaultTopic}")
    private String defaultTopic;

    @Value("${mqtt.consumer.sharedSubPrefix}")
    private String sharedSubPrefix;

    @Value("${mqtt.consumer.qos}")
    private int qos;

    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MqttPahoMessageDrivenChannelAdapter inbound() {
        MqttPahoMessageDrivenChannelAdapter adapter =
                new MqttPahoMessageDrivenChannelAdapter("consumerClient", mqttClientFactory, sharedSubPrefix + defaultTopic);
        adapter.setQos(qos); // 设置QoS
        adapter.setOutputChannel(mqttInputChannel());
        return adapter;
    }
}
