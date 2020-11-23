package com.didispace.charpter11.controller;

import com.didispace.charpter11.domain.User;
import com.didispace.charpter11.service.UserService;
import com.didispace.charpter11.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pub/user")
public class UserController {

//    @PostMapping("login")
//    public JsonData login(String pwd, String username){
//        System.out.println(username);
//        System.out.println(pwd);
//        return JsonData.buildSuccess("");
//    }

    @Autowired
    public UserService userService;

    /**
     * 登陆接口
     * @param user
     * @return
     */
    @PostMapping("login")
    public JsonData login(@RequestBody User user){
        System.out.println(user);
        String token = userService.login(user.getUsername(), user.getPwd());
        return token != null ? JsonData.buildSuccess(token) : JsonData.buildError("账号密码错误");
    }

    /**
     * 列出全部用户
     * @return
     */
    @GetMapping("list_user")
    public JsonData listUser(){
        return JsonData.buildSuccess(userService.listUser());
    }
}
