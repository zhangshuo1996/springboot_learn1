package com.didispace.charpter11.controller;

import com.didispace.charpter11.config.WXConfig;
import com.didispace.charpter11.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("api/v1/test")
@PropertySource({"classpath:pay.properties"})
public class TestController {

//    注入的第一种方式： @Value
    @Value("${wxpay.appid}")
    private String payAppid;

    @Value("${wxpay.secret}")
    private String paySecret;

    @Autowired
    private WXConfig wxConfig;


    /**
     * 自定义异常处理，配置全局异常
     * @return
     */
    @GetMapping("list")
    public JsonData testExt(){
//        int i = 1/0;
        return JsonData.buildSuccess("");
    }

    @GetMapping("get_config")
    public JsonData testConfig(){

//        方式1： 直接获取配置文件的参数
//        Map<String, String> map = new HashMap<>();
//        map.put("appid", payAppid);
//        map.put("secret", paySecret);
//        return JsonData.buildSuccess(map);

//        方式2：使用配置类获取配置文件中的参数
        Map<String, String> map = new HashMap<>();
        map.put("appid", wxConfig.getPayAppid());
        map.put("secret", wxConfig.getPaySecret());
        return JsonData.buildSuccess(map);
    }
}
