package Utils.result;

import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class RequestIdGeneratorImpl implements IRequestIdGenerator {
    protected static final Logger logger = LoggerFactory.getLogger(RequestIdGeneratorImpl.class);
    protected String request_id = "request_id";

    public RequestIdGeneratorImpl() {
    }

    public String getRequestId() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return UUID.randomUUID().toString();
        } else {
            HttpServletRequest request = requestAttributes.getRequest();
            Object attribute = request.getAttribute(this.request_id);
            logger.info("RequestIdGeneratorImpl getRequestId is {}", attribute);
            if (attribute == null) {
                attribute = UUID.randomUUID().toString();
            }

            logger.info("RequestIdGeneratorImpl requestId assigned is {}", attribute);
            return (String)attribute;
        }
    }
}