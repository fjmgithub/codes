package com.tedu.cloud.service;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalances {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
