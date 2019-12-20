package com.example.demo.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*@ResponseBody  //这个类的所有方法返回的数据直接写给浏览器，（如果对象转为json数据）
@Controller   //Controller控制器*/
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
