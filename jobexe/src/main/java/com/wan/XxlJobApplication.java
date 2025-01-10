package com.wan;

/**
 * <p>PURPOSE:
 * <p>DESCRIPTION: 启动类
 * <p>CALLED BY: wanjian
 * <p>CREATE DATE: 2025/1/10
 * <p>UPDATE DATE: 2025/1/10
 * <p>UPDATE USER:
 * <p>HISTORY: 1.0
 *
 * @author wanjian
 * @version 1.0
 * @see
 * @since java 1.8
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
public class XxlJobApplication {
    public static void main(String[] args) {
        SpringApplication.run(XxlJobApplication.class, args);
        // 阻止程序退出
        try {
            new CountDownLatch(1).await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
