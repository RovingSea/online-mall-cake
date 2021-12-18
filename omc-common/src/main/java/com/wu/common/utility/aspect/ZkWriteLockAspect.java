package com.wu.common.utility.aspect;

import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 分布式写锁
 * @author Haixin Wu
 * @date 2021/12/18: 15:22
 * @since 1.0
 */
@Aspect
@Component
@Order(2)
public class ZkWriteLockAspect extends AbstractZkLockAspect{

    private final InterProcessMutex writeLock;

    @Autowired
    public ZkWriteLockAspect(InterProcessMutex writeLock) {
        this.writeLock = writeLock;
    }

    /**
     * 使用ZkLock注解后既可以执行切面方法
     */
    @Pointcut("@annotation(com.wu.common.utility.annotation.ZkWriteLock)")
    public void methodAspect(){}

    @Around("methodAspect()")
    public Object execute(ProceedingJoinPoint joinPoint) throws Exception {
        return executeInLock(joinPoint, writeLock);
    }

}

