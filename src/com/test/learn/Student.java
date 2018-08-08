package com.test.learn;

import lombok.Data;

import org.springframework.beans.factory.annotation.Required;

@Data
public class Student {
    private Integer age;
    private String name;

//    public Integer getAge() {
//        return age;
//    }
//
//    //Required注解setter方法，表明该属性配置必须在xml进行配置，否则抛出异常
//    @Required
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}
