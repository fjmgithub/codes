package com.tedu.cloud.service.impl;

import com.tedu.cloud.service.LoadBalances;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: FJM
 * @Date 2022年01月07日 9:13
 * @Description: 实现
 */
@Service
public class LoadBalancesImpl implements LoadBalances {
    private static final Logger logger = LoggerFactory.getLogger(LoadBalancesImpl.class);
    private final AtomicInteger atomicInteger = new AtomicInteger(0);
    //负载均衡算法：rest接口第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下标  ，每次服务重启动后rest接口计数从1开始。
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }

    private int getAndIncrement() {
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        } while (!atomicInteger.compareAndSet(current, next));
        String info = "次数: " + next;
        logger.info(info);
        return next;
    }

}
