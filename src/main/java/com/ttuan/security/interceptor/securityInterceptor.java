package com.ttuan.security.interceptor;

import Utils.IpUtil;
import Utils.LogPrintUtil;
import Utils.result.Responses;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import sun.plugin.javascript.navig5.JSObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class securityInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(IpUtil.getIpAddr(request));
        // 如果没有权限 则抛403异常 springboot会处理，跳转到 /error/403 页面

//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("code",403);
//        jsonObject.put("msg","该用户无权限");//TODO 返回编码
//        response.setCharacterEncoding("UTF-8");
//        response.setHeader("Content-Type", "application/json;charset=utf-8");
//        response.getWriter().write(jsonObject.toJSONString());
//        printLog(request,response);
        return true;
    }

//    private void printLog(HttpServletRequest req, HttpServletResponse res){
//        StringBuilder error = new StringBuilder();
//        error.append("\n==================================error-log-start===============================\n");
////        error.append("request_id=").append(responses.getRequest_id()).append("; \n");
//        error.append(LogPrintUtil.logRequest(req) + "\n\n")
//                .append(LogPrintUtil.logResponse(res) + "\n");
//        error.append("====================================error-log-end=================================\n");
//        log.error(error.toString());
//    }

}


