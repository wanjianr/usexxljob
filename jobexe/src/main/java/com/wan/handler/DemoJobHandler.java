package com.wan.handler;

import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

/**
 * <p>PURPOSE:
 * <p>DESCRIPTION: 执行器
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
@Component
public class DemoJobHandler {

    /**
     * 示例任务
     * @throws Exception
     */
    @XxlJob("simpleJobHandler")
    public void simpleJobHandler() throws Exception {
        System.out.println("Simple Job Handler executed at: " + System.currentTimeMillis());
    }
}
