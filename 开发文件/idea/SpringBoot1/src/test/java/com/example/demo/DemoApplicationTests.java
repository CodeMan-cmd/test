package com.example.demo;

import com.example.demo.bena.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/***
 * @SpringBootTest表示这是一测试类
 * @RunWith(SpringRunner.class)加载驱动
 * 可以再测试期间自动注入的功能
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    public Person person;

    @Autowired
    ApplicationContext ioc;

    @Test
    public void contextLoads() {
        System.out.println(person);
    }
    @Test
    public void testHelloService(){
        boolean b=ioc.containsBean("helloService");
        System.out.println(b);
    }
}
