package com.springcloud.controller;

import com.springcloud.common.Result;
import com.springcloud.pojo.User;
import com.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> getall(){
        List<User> allUsers = userService.list();
        return allUsers;
    }
    @GetMapping("/findByNo")
    public Result findByNo(@RequestParam String no) {
        return userService.findByNo(no);
    }
}
