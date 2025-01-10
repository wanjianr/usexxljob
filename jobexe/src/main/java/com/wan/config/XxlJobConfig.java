package com.wan.config;
import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>PURPOSE:
 * <p>DESCRIPTION: xxljob配置
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
@Configuration
public class XxlJobConfig {

    @Bean
    public XxlJobSpringExecutor xxlJobExecutor() {
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses("http://localhost:8080/xxl-job-admin");
        xxlJobSpringExecutor.setAppname("xxl-job-executor");
        xxlJobSpringExecutor.setLogPath("./data/applogs/xxl-job/jobhandler");
        xxlJobSpringExecutor.setAccessToken("default_token");
        return xxlJobSpringExecutor;
    }

//    @Bean
//    public XxlJobSpringExecutor xxlJobExecutor() {
//        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
//        xxlJobSpringExecutor.setAdminAddresses("http://127.0.0.1:8080/xxl-job-admin"); // 管理平台地址
//        xxlJobSpringExecutor.setAppname("demo-executor"); // 执行器名称
//        xxlJobSpringExecutor.setPort(9999); // 执行器服务端口
//        xxlJobSpringExecutor.setLogPath("./data/applogs/xxl-job/jobhandler"); // 日志路径
//        xxlJobSpringExecutor.setLogRetentionDays(30); // 日志保留天数
//        return xxlJobSpringExecutor;
//    }
}
