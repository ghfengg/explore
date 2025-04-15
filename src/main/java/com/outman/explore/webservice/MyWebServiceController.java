package com.outman.explore.webservice;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yangfeng
 * @date 2025/01/24
 * @description: 描述信息
 */
@RestController
public class MyWebServiceController {

    @PostMapping("/XISOAPAdapter/MessageServlet")
    @ResponseBody
    public String mywebservice(@RequestBody String soapXml, HttpServletRequest request) {
        String requestUri = request.getRequestURI();
        System.out.println("requestUri:" + requestUri);

        String senderService = request.getParameter("senderService");
        System.out.println("request param `senderService`:" + senderService);

        String orgId = request.getHeader("orgId");
        System.out.println("orgId:" + orgId);

        return soapXml;
    }

    @RequestMapping("/ws/test")
    @ResponseBody
    public String hello() {
        return "hello";
    }
}
