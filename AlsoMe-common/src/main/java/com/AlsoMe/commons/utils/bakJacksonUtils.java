package com.AlsoMe.commons.utils;

import com.AlsoMe.commons.entity.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class bakJacksonUtils {

    //将POJO转成json格式的字符串
    public void TestJOPO2Json1(){
        //创建ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        Student student1 = new Student("001","Jack","Male","18765456543");
        try {
            //将对象写入json字符串
            String stringPOJOJson = mapper.writeValueAsString(student1);
            System.out.println(stringPOJOJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //将POJO写入json文件
    public void TestJOPO2Json2(){
        //创建ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        Student student1 = new Student("001","Jack","Male","18765456543");
        try {
            //将对象写入json文件
            mapper.writeValue(new File("json/jack.json"),student1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //将集合对象写入json文件
    public void TestJOPO2Json3() {
        //创建ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        Student student2 = new Student("002", "Tom", "Male", "18765466643");
        Student student3 = new Student("003", "JackSon", "Male", "18765477743");
        List<Student> students = new ArrayList<>();
        students.add(student2);
        students.add(student3);

        //将集合对象写入json文件
        try {
            mapper.writeValue(new File("json/students.json"), students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   // 将json格式的String字符串转为POJO对象
    public void TestJson2JOPO1() {
        //Json字符串转POJO
        ObjectMapper mapper = new ObjectMapper();
        String JackJson = "{\"id\":\"001\",\"name\":\"Jack\",\"gender\":\"Male\",\"phone\":\"18765456543\"}";
        try {
            Student Jack = mapper.readValue(JackJson, Student.class);
            System.out.println(Jack.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //将json文件转成POJO对象
    public void TestJson2JOPO2() {
        //Json文件转POJO
        ObjectMapper mapper = new ObjectMapper();
        try {
            Student Jack = mapper.readValue(new File("json/jack.json"), Student.class);
            System.out.println(Jack.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //将数组类型的json文件转为List集合
    public void TestJson2JOPO3() {
        //Json数组文件转List集合
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Student> students = mapper.readValue(new File("json/students.json"), new TypeReference<ArrayList<Student>>() {
            });
            for (Student student : students) {
                System.out.println(student.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ParseException, JsonProcessingException {


    }
}

