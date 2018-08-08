package com.test.learn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-annotation.xml");

        Student student = (Student) context.getBean("student");
        System.out.println(student.getName());
        System.out.println(student.toString());
    }
}
