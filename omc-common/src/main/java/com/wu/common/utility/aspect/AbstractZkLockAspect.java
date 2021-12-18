package com.wu.common.utility.aspect;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * 抽象分布式锁
 * @author Haixin Wu
 * @date 2021/12/18 15:19
 * @since 1.0
 */
@Component
@Slf4j
public abstract class AbstractZkLockAspect {

    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public Object executeInLock(ProceedingJoinPoint joinPoint, InterProcessMutex lock) throws Exception {
        Object o = null;
        try {
            MethodSignature signature = (MethodSignature)joinPoint.getSignature();
            // 上锁
            lock.acquire();
            // 记时
            long start = System.currentTimeMillis();
            // 执行切面
            o = joinPoint.proceed();
            // 返回切面方法所有的参数
            Object[] args = joinPoint.getArgs();
            log.info("signature.toString()" + signature.toString());
            log.info("{} 调用时间：{}", signature, SDF.format(new Date()));
            // 目标执行完成并记录结束时间
            long end = System.currentTimeMillis();
            log.info("{} 执行时间：{}", signature.toString(), end - start);
            //启动一个线程 异步打印日志
            log.info("{} 方法入参{}", signature.toString(),new ArrayList<>(Arrays.asList(args)).stream().map(Object::toString).collect(Collectors.joining(",")));
        } catch(Throwable e){
            e.printStackTrace();
        } finally{
            lock.release();
        }
        return o;
    }

}

