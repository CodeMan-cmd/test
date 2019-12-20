package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/***
 * @SpringBootApplication表示这是一个springboot应用
 * @ImportResource(locations = {"classpath:bean.xml"}){
 * 导入Spring的配置文件，让配置文件里面的内容生效
 * }
 */
/*@ImportResource(locations = {"classpath:bean.xml"})*/
@SpringBootApplication
public class DemoApplication {
        public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
