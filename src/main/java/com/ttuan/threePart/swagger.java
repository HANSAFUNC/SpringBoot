package com.ttuan.threePart;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum headerType {
    token,
    system_os,
}

@Configuration
@EnableSwagger2
public class swagger {


    private List<HashMap<String, String>>  parameters;

    /**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义指定要建立API的目录。
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {
        List<Parameter> pars = new ArrayList<Parameter>();
        System.out.println(getParameters());
       for (HashMap<String,String> map : getParameters()) {
           ParameterBuilder par = new ParameterBuilder();
           par.name(map.get("headerType")).description(map.get("des"))
                   .modelRef(new ModelRef(map.get("dataType"))).parameterType("header").required(false).build();
           pars.add(par.build());
        }

        List<ResponseMessage> responseMessageList = new ArrayList<>();
        responseMessageList.add(new ResponseMessageBuilder().code(404).message("找不到资源").responseModel(new ModelRef("Responses")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(409).message("业务逻辑异常").responseModel(new ModelRef("Responses")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(422).message("参数校验异常").responseModel(new ModelRef("Responses")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(500).message("服务器内部错误").responseModel(new ModelRef("Responses")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(503).message("Hystrix异常").responseModel(new ModelRef("Responses")).build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ttuan.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars)
                .globalResponseMessage(RequestMethod.GET, responseMessageList)
                .globalResponseMessage(RequestMethod.POST, responseMessageList)
                .globalResponseMessage(RequestMethod.PUT, responseMessageList)
                .globalResponseMessage(RequestMethod.DELETE, responseMessageList);

    }
    @Bean
    public Docket createMonitorRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("实时监测")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ttuan.controller"))
                .paths(PathSelectors.any())
                .build();
    }


    /**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * 访问地址：http://项目实际地址/swagger-ui.html
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("最紧要开心 RESTful APIs")
                .description("测试")
                .termsOfServiceUrl("http://www.baidu.com")
                .contact("Jan.")
                .version("1.0")
                .build();

    }

    public List<HashMap<String, String>> getParameters() {
        if (parameters == null) {
            parameters = new ArrayList<HashMap<String, String>>();
            HashMap m1 = new HashMap<String,String>();
            m1.put("headerType" , "token");
            m1.put("dataType" , "String");
            m1.put("des" , "登陆获取令牌");

            HashMap m2 = new HashMap<String,String>();
            m2.put("headerType", "system OS");
            m2.put("dataType" , "String");
            m2.put("des" , "系统类型");
            parameters.add(m1);
            parameters.add(m2);
        }
        return parameters;
    }


//    public HashMap<String, String> getParameters() {
//        if (parameters == null) {
//            parameters = new  HashMap<String, String>();
//            parameters.put("token","String");
//            parameters.put("system OS","String");
//        }
//        return parameters;
//    }
}