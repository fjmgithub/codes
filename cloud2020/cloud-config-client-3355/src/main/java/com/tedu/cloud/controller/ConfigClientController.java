package com.tedu.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: FJM
 * @Date 2022年01月13日 16:17
 * @Description: 配置中心客户端
 */
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;
    @GetMapping("/getConfigInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
