package Utils;

//import com.cdoboe.common.filter.RequestWrapper;
//import com.cdoboe.common.filter.ResponseWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;

/**
 * @Auther: shun_c
 * @Date: 2019/6/10 09:56
 * @Description:  日志打印工具
 */
public class LogPrintUtil {

    private static final String REQUEST_PREFIX = "Request: \n";
    private static final String RESPONSE_PREFIX = "Response: \n";
    private static final String ERROR_PREFIX = "Error: \n";


    /**
     *
     * @param request
     * @return
     */
    public static String logRequest(HttpServletRequest request) {
        StringBuilder msg = new StringBuilder();
        msg.append(REQUEST_PREFIX);
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            msg.append(key).append("=").append(value).append(";\n");
        }
        if (request.getMethod() != null) {
            msg.append("method=").append(request.getMethod()).append(";\n");
        }
        if (request.getContentType() != null) {
            msg.append("content type=").append(request.getContentType()).append(";\n");
        }
        msg.append("url=").append(request.getRequestURI());
        if (request.getQueryString() != null) {
            msg.append('?').append(request.getQueryString());
        }
        msg.append("\n");
//        if (request instanceof RequestWrapper) {
//            RequestWrapper requestWrapper = (RequestWrapper) request;
//            try {
//                String charEncoding = requestWrapper.getCharacterEncoding() != null ? requestWrapper.getCharacterEncoding() :
//                        "UTF-8";
//                msg.append("payload=").append(new String(requestWrapper.toByteArray(), charEncoding));
//            } catch (UnsupportedEncodingException e) {
//                msg.append("payload=").append(String.format("Failed to parse request payload[%s]", e));
//            }
//        }
        return msg.toString();
    }

    /**
     *
     * @param response
     * @return
     */
    public static String logResponse(HttpServletResponse response) {
        StringBuilder msg = new StringBuilder();
        msg.append(RESPONSE_PREFIX);
//        if (response instanceof ResponseWrapper) {
//            ResponseWrapper responseWrapper = (ResponseWrapper) response;
//            try {
//                msg.append("payload=").append(new String(responseWrapper.toByteArray(), responseWrapper.getCharacterEncoding()));
//            } catch (UnsupportedEncodingException e) {
//                msg.append("payload=").append(String.format("Failed to parse response payload[%s]", e));
//            }
//        }
        return msg.toString();
    }

    /**
     * 获取错误的堆栈信息
     * @param e
     * @return
     */
    public static String getStackTrace(Exception e){
        StringWriter stringWriter=new StringWriter();
        stringWriter.append(ERROR_PREFIX);
        PrintWriter printWriter=new PrintWriter(stringWriter);
        try {
            e.printStackTrace(printWriter);
            return stringWriter.toString();
        }finally {
            printWriter.close();
        }
    }
}
