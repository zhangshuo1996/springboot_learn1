package com.didispace.charpter11.service;

import com.didispace.charpter11.domain.User;

import java.util.List;

public interface UserService {

    String login(String username, String pwd);

    List<User> listUser();
}
