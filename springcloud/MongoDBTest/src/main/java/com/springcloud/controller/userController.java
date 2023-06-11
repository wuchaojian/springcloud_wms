package com.springcloud.controller;

import com.springcloud.common.QueryPageParam;
import com.springcloud.common.Result;
import com.springcloud.pojo.User;
import com.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> getall(){
        return userService.list();
    }
    @GetMapping("/findByNo")
    public Result findByNo(@RequestParam String no){
        return userService.findByNo(no);
    }
    //新增
    @PostMapping("/save")
    public Result save(@RequestBody User user){
        return userService.save(user);
    }
    //更新
    @PostMapping("/update")
    public Result update(@RequestBody User user){
        return userService.update(user);
    }
    //删除
    @GetMapping("/del")
    public Result del(@RequestParam String id){
        return userService.del(id);
    }

    //登录
    @PostMapping("/login")
    public Result login(@RequestBody User user){
//        System.out.println("xxx");
        return userService.login(user);
    }

    //修改
    @PostMapping("/mod")
    public boolean mod(@RequestBody User user){
        return userService.mod(user);
    }
    //新增或修改
    @PostMapping("/saveOrMod")
    public boolean saveOrMod(@RequestBody User user){
        return userService.saveOrMod(user);
    }
    //删除
    @GetMapping("/delete")
    public boolean delete(Integer id){
        return userService.delete(id);
    }

    //查询（模糊、匹配）
    @PostMapping("/listP")
    public Result listP(@RequestBody User user){
        return userService.listP(user);
    }

    @PostMapping("/listPage")
    public List<User> listPage(@RequestBody QueryPageParam query){
        return userService.listPage(query);
    }

    @PostMapping("/listPageC")
    public List<User> listPageC(@RequestBody QueryPageParam query){
        return userService.listPageC(query);
    }

    @PostMapping("/listPageC1")
    public Result listPageC1(@RequestBody QueryPageParam query){
        return userService.listPageC1(query);
    }
}
