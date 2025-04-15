package com.outman.explore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangfeng
 * @date 2025/01/21
 * @description: 描述信息
 */
@RestController
public class TestController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello!";
    }
}
