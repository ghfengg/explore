package com.outman.explore.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author yangfeng
 * @date 2025/01/24
 * @description: 描述信息
 */
@WebService
public class MyWebService {
    @WebMethod
    public String getGreeting(String name) {
        return "Hello, " + name + "!";
    }
}
