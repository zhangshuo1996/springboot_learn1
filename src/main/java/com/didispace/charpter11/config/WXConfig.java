package com.didispace.charpter11.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration  // 该注解表明该类是配置类
@PropertySource(value = "classpath:pay.properties")  // 配置文件路径
public class WXConfig {

    @Value("${wxpay.appid}")
    private String payAppid;

    @Value("${wxpay.secret}")
    private String paySecret;

    @Value("${wxpay.mechid}")
    public String getPayAppid() {
        return payAppid;
    }

    public void setPayAppid(String payAppid) {
        this.payAppid = payAppid;
    }

    public String getPaySecret() {
        return paySecret;
    }

    public void setPaySecret(String paySecret) {
        this.paySecret = paySecret;
    }

    public String getPayMechId() {
        return payMechId;
    }

    public void setPayMechId(String payMechId) {
        this.payMechId = payMechId;
    }

    private String payMechId;



}
