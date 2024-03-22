package com.aa.knowledgebase.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/123")
@Api(tags = "hello")
@Slf4j
public class HelloController {

    @GetMapping("/")
    @ApiOperation("欢迎界面")
    public String hello(){
        return "hello world";
    }

    @PostMapping("/submitForm")
    @ApiOperation("表单")
    public String submitForm(@RequestParam("name") String name, @RequestParam("email") String email) {
        // 在这里可以处理表单提交的数据，比如保存到数据库或者进行其他逻辑处理
        // 这里只是一个简单的示例
        System.out.println("Received form submission - Name: " + name + ", Email: " + email);

        // 可以返回一个成功页面或者重定向到其他页面
        return "success"; // 返回名为success的HTML页面
    }
}
