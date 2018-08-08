package com.test.generic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-generic.xml");

        UserService userService = (UserService) context.getBean("userService");
        userService.add();
    }
}
