package com.tedu.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

/**
 * @Author: FJM
 * @Date 2022年01月06日 15:55
 * @Description: ribbon负载均衡策略
 */
public class MyRibbonRule {
    //官方文档明确给出了警告:
    //这个自定义配置类不能放在@ComponentScan所扫描的当前包下以及子包下
    //也就是说不要将Ribbon配置类与主启动类同包
    @Bean
    public IRule myRule(){
        return new RandomRule();//随机
    }
}
