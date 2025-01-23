package com.wan.mqtt.controller;

import com.wan.mqtt.gateway.MqttProducerGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>PURPOSE:
 * <p>DESCRIPTION: mqtt消息提供者控制层
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
@RestController
public class MqttProducerController {

    @Autowired
    private MqttProducerGateway mqttProducerGateway;

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        mqttProducerGateway.sendMessage(message);
        return "Message sent: " + message;
    }
}
