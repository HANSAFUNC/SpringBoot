package com.ttuan.handler;

import Utils.LogPrintUtil;
import Utils.result.Responses;
import com.ttuan.Define.StateCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
@Slf4j
public class WebExceptionHandleAdvice {

    @ExceptionHandler
    public Responses apiExceptionHandler(HttpServletRequest req, HttpServletResponse res, Exception e) {
        Responses responses;
        responses = Responses.fail(StateCodeEnum.FAIL.getCode(),StateCodeEnum.FAIL.getValue());
        return responses;
    }

    /**
     * 打印
     * @param responses
     * @param req
     * @param res
     * @param e
     */
    private void printLog(Responses responses, HttpServletRequest req, HttpServletResponse res, Exception e){
        StringBuilder error = new StringBuilder();
        error.append("\n==================================error-log-start===============================\n");
        error.append("request_id=").append(responses.getRequest_id()).append("; \n");
        error.append(LogPrintUtil.logRequest(req) + "\n\n")
                .append(LogPrintUtil.getStackTrace(e)+"\n\n")
                .append(LogPrintUtil.logResponse(res) + "\n");
        error.append(e).append("\n");
        error.append("====================================error-log-end=================================\n");
        log.error(error.toString(), e);
    }
}
