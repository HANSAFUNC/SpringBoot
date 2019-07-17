package Utils.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.http.ResponseEntity;
import java.io.Serializable;
@ApiModel(value = "返回说明")
public class Responses<T> implements Serializable{
    private String request_id;
    @ApiModelProperty(value = "描述信息")
    private String msg;
    @ApiModelProperty(value = "返回状态码；200:成功")
    private Integer code;

    @ApiModelProperty(value = "结果数据", position = 4 )
    private T data;

    private Responses() {
    }


    private static <T> Responses build() {
        Responses<T> responses = new Responses<T>();
        IRequestIdGenerator idGenerator = new RequestIdGeneratorImpl();
        String requestId = idGenerator.getRequestId();
        responses.setRequest_id(requestId);
        return responses;
    }

    public static <T>Responses ok() {
        Responses<T> responses = build();
        responses.setCode(200);
        responses.setMsg("SUCCESS");
        return responses;
    }

    public static <T> Responses ok(T result) {
        Responses<T> ok = ok();
        ok.setData(result);
        return ok;
    }

    public static Responses ok(Integer code, String msg, Object result) {
        Responses responses = ok();
        responses.setCode(code);
        responses.setMsg(msg);
        responses.setData(result);
        return responses;
    }

    public static Responses fail(Integer code, String msg) {
        Responses responses = fail();
        responses.setCode(code);
        responses.setMsg(msg);
        return responses;
    }

    public static Responses fail(Integer code, String msg, Object result) {
        Responses fail = fail(code, msg);
        fail.setData(result);
        return fail;
    }

    public static Responses fail(String msg) {
        Responses responses = fail();
        responses.setMsg(msg);
        return responses;
    }

    public static Responses fail() {
        Responses responses = build();
        responses.setCode(500);
        responses.setMsg("ERROR");
        return responses;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getRequest_id() {
        return this.request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }
}