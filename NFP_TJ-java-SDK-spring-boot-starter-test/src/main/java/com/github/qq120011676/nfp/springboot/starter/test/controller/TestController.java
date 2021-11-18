package com.github.qq120011676.nfp.springboot.starter.test.controller;

import com.github.qq120011676.nfp.springboot.starter.test.config.Config;
import com.github.qq120011676.nfptj.NFPTJ;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("test")
public class TestController {
    @Resource
    private Config config;

    @RequestMapping("config")
    public Config config() {
        return config;
    }

    @Resource
    private NFPTJ nfptj;

    @RequestMapping("token")
    public String token() {
        return nfptj.getToken();
    }
}
