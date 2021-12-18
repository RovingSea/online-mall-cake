package com.wu.common.utility.annotation;

import java.lang.annotation.*;

/**
 * 由于分布式项目开发，各个jar包是分散到不同的地方运行，为了解决JVM不在同一所在地，而导致堆中对象的对象头运行时数据不同，
 * 所以基于Zookeeper搭建分布式锁，该注解指向分布式锁——读写锁中的<b>写锁，作用于大量业务中的写操作，</b>
 * 以确保事务的一致性，避免读写事务中造成脏读、幻读及不可重复读的现象发生，
 * 其在Zookeeper中默认指向的地址是4DAS-lock，可在{@link com.wu.common.config.ZkReadWriteConfig}处更改
 * <pre>具体实现可以查看该类 {@link com.wu.common.utility.aspect.ZkWriteLockAspect}</pre>
 * @author Haixin wu
 * @since 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ZkWriteLock {

}

