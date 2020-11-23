package com.didispace.charpter11.intercepter;

import com.didispace.charpter11.domain.User;
import com.didispace.charpter11.service.impl.UserServiceImpl;
import com.didispace.charpter11.utils.JsonData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class LoginInterceptor implements HandlerInterceptor {

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("LoginInterceptor preHandler===========");

        String token = request.getHeader("token");
        if(StringUtils.isEmpty(token)){
            token = request.getParameter("token");
        }

        if(!StringUtils.isEmpty(token)){ //
            // 判断token是否合法 TODO
            Map<String, User> map = UserServiceImpl.sessionMap;
            User user = map.get(token);
            if(user != null){  // token 合法
                return true;

            }else{ // 不合法
                JsonData jsonData = JsonData.buildError("登录失败， token无效" ,-2);
                String jsonStr = objectMapper.writeValueAsString(jsonData);
                renderJson(response, jsonStr);
                return false;
            }
        }else{ // 没有收到token
            JsonData jsonData = JsonData.buildError("未登录， token无效" ,-3);
            String jsonStr = objectMapper.writeValueAsString(jsonData);
            renderJson(response, jsonStr);
            return false;
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
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("LoginInterceptor postHandler===========");

        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("LoginInterceptor afterHandler===========");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);

    }
}
