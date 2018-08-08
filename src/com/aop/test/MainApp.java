package com.aop.test;

import com.aop.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-aop.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.add();
    }

}
