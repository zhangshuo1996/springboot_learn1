package com.didispace.charpter11.handler;

import com.didispace.charpter11.utils.JsonData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 标记这是一个异常处理类
 *
 */
//@RestControllerAdvice // 标志专门处理异常， 返回的是Json数据
@ControllerAdvice
public class CustomerExtHandler {
//    @ExceptionHandler(value=Exception.class) // 异常种类
//    Object handlerException(Exception e, HttpServletRequest request){
//        return JsonData.buildError("服务端出问题了", -2);
//    }

    @ExceptionHandler(value=Exception.class) // 异常种类
    Object handlerException(Exception e, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error.html");
        System.out.println(e.getMessage());
        modelAndView.addObject("msg", e.getMessage());
        return modelAndView;
    }
}
