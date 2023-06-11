package com.springcloud.controller;

import com.springcloud.api.User;
import com.springcloud.common.QueryPageParam;
import com.springcloud.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    //通过服务名来获取url
    private static final String url_PREFIX="http://springcloud-provider-login2";
//    private static final String url_PREFIX="http://localhost:8802";
    @RequestMapping("/list")
    public List list(){
        return restTemplate.getForObject(url_PREFIX+"/user/list",List.class);
    }
    @PostMapping("/save")
    public Result save(@RequestBody User user){
        return restTemplate.postForObject(url_PREFIX+"/user/save", user, Result.class);
    }
    @GetMapping("/findByNo")
    public Result findByNo(@RequestParam String no){
        return restTemplate.getForObject(url_PREFIX+"/user/findByNo?no="+no,Result.class);
    }
    // 更新
    @PostMapping("/update")
    public Result update(@RequestBody User user) {
        String url = url_PREFIX + "/user/update";
        return restTemplate.postForObject(url, user, Result.class);
    }

    // 删除
    @GetMapping("/del")
    public Result del(@RequestParam String id) {
        String url = url_PREFIX + "/user/del?id=" + id;
        return restTemplate.getForObject(url, Result.class);
    }
//登录
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        String url = url_PREFIX + "/user/login";
        return restTemplate.postForObject(url, user, Result.class);
    }

    @PostMapping("/mod")
    public boolean mod(@RequestBody User user) {
        String url = url_PREFIX + "/user/mod";
        return restTemplate.postForObject(url, user, Boolean.class);
    }

    @PostMapping("/saveOrMod")
    public boolean saveOrMod(@RequestBody User user) {
        String url = url_PREFIX + "/user/saveOrMod";
        return restTemplate.postForObject(url, user, Boolean.class);
    }

    @GetMapping("/delete")
    public boolean delete(Integer id) {
        String url = url_PREFIX + "/user/delete?id=" + id;
        return restTemplate.getForObject(url, Boolean.class);
    }

    @PostMapping("/listP")
    public Result listP(@RequestBody User user) {
        String url = url_PREFIX + "/user/listP";
        return restTemplate.postForObject(url, user, Result.class);
    }

    @PostMapping("/listPage")
    public List<User> listPage(@RequestBody QueryPageParam query) {
        String url = url_PREFIX + "/user/listPage";
        return restTemplate.postForObject(url, query, List.class);
    }

    @PostMapping("/listPageC")
    public List<User> listPageC(@RequestBody QueryPageParam query) {
        String url = url_PREFIX + "/user/listPageC";
        return restTemplate.postForObject(url, query, List.class);
    }

    @PostMapping("/listPageC1")
    public Result listPageC1(@RequestBody QueryPageParam query) {
        String url = url_PREFIX + "/user/listPageC1";
        return restTemplate.postForObject(url, query, Result.class);
    }

}
