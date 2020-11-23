package com.didispace.charpter11;

import com.didispace.charpter11.controller.UserController;
import com.didispace.charpter11.domain.User;
import com.didispace.charpter11.utils.JsonData;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Charpter11Application.class})
public class USerTest {

    @Autowired
    private UserController userController;

    @Test
    public void loginTest(){
        User user = new User();
        user.setUsername("jack");
        user.setPwd("123");
//        user.setPwd("1232");

        JsonData jsonData = userController.login(user);

        System.out.println(jsonData);

        TestCase.assertEquals(0, jsonData.getCode());
    }
}
