package com.AlsoMe.commons.entity;

import lombok.Data;

@Data
public class Student {
    private String id;
    private String name;
    private String gender;
    private String phone;

    public Student() {}

    public Student(String id, String name, String gender, String phone) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
    }

    //省略getter和setter

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}