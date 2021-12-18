package com.wu.common.config;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Zookeeper读写锁配置
 * @author Haixin Wu
 * @date 2021/12/18 15:08
 * @since 1.0
 */
@Configuration
public class ZkReadWriteConfig {

    private static final String ZK_READ_WRITE_LOCATION_PATH = "/wu-omc-lock";

    private final CuratorFramework zkCli;

    @Autowired
    public ZkReadWriteConfig(CuratorFramework zkCli) {
        this.zkCli = zkCli;
    }

    @Bean
    public InterProcessMutex readLock(){
        return new InterProcessReadWriteLock(zkCli, ZK_READ_WRITE_LOCATION_PATH).readLock();
    }

    @Bean
    public InterProcessMutex writeLock(){
        return new InterProcessReadWriteLock(zkCli, ZK_READ_WRITE_LOCATION_PATH).writeLock();
    }
}

