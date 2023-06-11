package com.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {
    @Autowired
    private RestTemplate restTemplate;
//    private static final String url_PREFIX="http://localhost:8801";
//通过服务名来获取url
    private static final String url_PREFIX="http://springcloud-provider-login";
//    @RequestMapping("/consumer/dept/get/{id}")
//    public Dept get(@PathVariable("id")long id){
//        return restTemplate.getForObject(url_PREFIX+"/dept/get/"+id,Dept.class);
//    }
//
//    @RequestMapping("/consumer/dept/add")
//    public boolean add(Dept dept){
//        String url = UriComponentsBuilder.fromHttpUrl(url_PREFIX + "/dept/add")
//                .queryParam("dname", dept.getDname())
//                .toUriString();
//        // 发送GET请求
//        return restTemplate.getForObject(url, Boolean.class);
//    }
    @RequestMapping("/consumer/dept/list")
    public List queryAll(){
        return restTemplate.getForObject(url_PREFIX+"/user/list",List.class);
    }

}
