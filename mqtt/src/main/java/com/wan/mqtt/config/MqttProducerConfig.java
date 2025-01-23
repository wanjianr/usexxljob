package com.wan.mqtt.config;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
/**
 * <p>PURPOSE:
 * <p>DESCRIPTION: mqtt配置类
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
public class MqttProducerConfig {


    @Value("${mqtt.url}")
    private String brokerUrl;

    @Value("${mqtt.userName}")
    private String username;

    @Value("${mqtt.password}")
    private String password;

    @Value("${mqtt.willTopic}")
    private String willTopic;

    @Value("${mqtt.timeout}")
    private int timeout;

    @Value("${mqtt.keepalive}")
    private int keepalive;

    @Value("${mqtt.cleanSession}")
    private boolean cleanSession;

    @Value("${mqtt.producer.clientId}")
    private String clientId;

    @Bean
    public MqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        MqttConnectOptions options = new MqttConnectOptions();
        options.setServerURIs(new String[] { brokerUrl });
        options.setUserName(username);
        options.setPassword(password.toCharArray());
        options.setWill(willTopic, "offline".getBytes(), 1, false); // 设置“遗嘱”消息
        options.setConnectionTimeout(timeout);
        options.setKeepAliveInterval(keepalive);
        options.setCleanSession(cleanSession);
        options.setMaxInflight(5000); // 设置最大飞行消息数
        factory.setConnectionOptions(options);
        return factory;
    }
}
