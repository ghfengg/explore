package com.outman.explore.webservice;

import javax.xml.ws.Endpoint;

/**
 * @author yangfeng
 * @date 2025/01/24
 * @description: 描述信息
 */
public class WebServicePublisher {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/mywebservice", new MyWebService());
        System.out.println("Web Service is published!");
    }

}
