package com.wu.common.config;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Haixin Wu
 * @date 2021/12/18 14:59
 * @since 1.0
 */
@Configuration
public class CuratorConfig {
    private final static String ZK_CLUSTER_ADDRESS = "39.96.61.59:2181,110.42.224.33:2181,180.76.136.123:2181";
    private final static int MAX_CONNECTION_TIME_OUT = 50000;
    private final static int MAX_SESSION_TIME_OUT = 10000;
    private final static int MAX_RECONNECTION_TIME_OUT = 3000;
    private final static int MAX_RETRIES = 3;


    @Bean
    public CuratorFramework curatorFramework(){
        ExponentialBackoffRetry policy = new ExponentialBackoffRetry(MAX_RECONNECTION_TIME_OUT, MAX_RETRIES);
        CuratorFramework client = CuratorFrameworkFactory.builder()
                //主机
                .connectString(ZK_CLUSTER_ADDRESS)
                //连接超时
                .connectionTimeoutMs(MAX_CONNECTION_TIME_OUT)
                //会话超时
                .sessionTimeoutMs(MAX_SESSION_TIME_OUT)
                //连接失败后，间隔多久再重试
                .retryPolicy(policy).build();
        //启动客户端
        client.start();

        return client;
    }
}

