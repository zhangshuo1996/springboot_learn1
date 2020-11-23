package com.didispace.charpter11.filter;

import com.didispace.charpter11.domain.User;
import com.didispace.charpter11.service.impl.UserServiceImpl;
import com.didispace.charpter11.utils.JsonData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

//@WebFilter(urlPatterns = "/api/v1/pri/*", filterName = "loginFilter")
public class LoginFilter implements Filter {

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 容器加载的时候
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init LoginFilter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("doFilter  LoginFilter ===========");

        HttpServletRequest req = (HttpServletRequest) servletRequest;

        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String token = req.getHeader("token");
        if(StringUtils.isEmpty(token)){
            token = req.getParameter("token");
        }

        if(!StringUtils.isEmpty(token)){ //
            // 判断token是否合法 TODO
            Map<String, User> map = UserServiceImpl.sessionMap;
            User user = map.get(token);
            if(user != null){  // token 合法
                filterChain.doFilter(servletRequest, servletResponse);
            }else{ // 不合法
                JsonData jsonData = JsonData.buildError("登录失败， token无效" ,-2);
                String jsonStr = objectMapper.writeValueAsString(jsonData);
                renderJson(resp, jsonStr);
            }
         }else{ // 没有收到token
            JsonData jsonData = JsonData.buildError("未登录， token无效" ,-3);
            String jsonStr = objectMapper.writeValueAsString(jsonData);
            renderJson(resp, jsonStr);
        }
    }

    private void renderJson(HttpServletResponse response, String json){
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        try(PrintWriter writer = response.getWriter()){
            writer.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        System.out.println("destroy LoginFilter");
    }
}
