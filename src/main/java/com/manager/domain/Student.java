package com.manager.domain;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Component
public class Student {

    @NotNull
    @Min(value = 1, message = "学号格式输入有误！")
    private long id;

    @NotNull
    private String name;

    private char sex;

    @NotNull
    private String clazz;

    @Min(value = 1, message = "电话格式输入有误！")
    private long phone;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public char getSex() {
        return sex;
    }
    public void setSex(char sex) {
        this.sex = sex;
    }
    public String getClazz() {
        return clazz;
    }
    public void setClazz(String clazz) {
        this.clazz = clazz;
    }
    public long getPhone() {
        return phone;
}
    public void setPhone(long phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", clazz='" + clazz + '\'' +
                ", phone=" + phone  + '}';
    }
}