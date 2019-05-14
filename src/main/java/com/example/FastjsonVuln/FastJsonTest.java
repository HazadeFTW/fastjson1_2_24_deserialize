package com.example.FastjsonVuln;

import java.io.IOException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;

public class FastJsonTest {

    public String name;
    public String age;
    public FastJsonTest() throws IOException{
    }

    public void setName(String test) {
        System.out.println("name setter called");
        this.name = test;
    }

    public String getName() {
        System.out.println("name getter called");
        return this.name;
    }

    public String getAge(){
        System.out.println("age getter called");
        return this.age;
    }

    public static void main(String[] args) {
        Object obj = JSON.parse(
                "{\"@type\":\"com.example.FastjsonVuln.FastJsonTest\",\"name\":\"thisisname\", \"age\":\"thisisage\"}"
        );
        System.out.println(obj);

        Object obj2 = JSON.parseObject(
                "{\"@type\":\"com.example.FastjsonVuln.FastJsonTest\",\"name\":\"thisisname\", \"age\":\"thisisage\"}"
        );
        System.out.println(obj2);
    }

}