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
 * 分布式读锁
 * @author Haixin Wu
 * @date 2021/12/18 15:26
 * @since 1.0
 */
@Aspect
@Component
@Order(2)
public class ZkReadLockAspect extends AbstractZkLockAspect{
    private final InterProcessMutex readLock;

    @Autowired
    public ZkReadLockAspect(InterProcessMutex readLock) {
        this.readLock = readLock;
    }

    /**
     * 使用ZkLock注解后既可以执行切面方法
     */
    @Pointcut("@annotation(com.wu.common.utility.annotation.ZkReadLock)")
    public void methodAspect(){}

    @Around("methodAspect()")
    public Object execute(ProceedingJoinPoint joinPoint) throws Exception {
        return executeInLock(joinPoint, readLock);
    }
}

