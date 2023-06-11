package com.springcloud.controller;

import com.springcloud.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/menu")
public class MenuConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    //通过服务名来获取url
    private static final String url_PREFIX="http://springcloud-provider-login2";

    @GetMapping("/list")
    public Result getMenuList(@RequestParam String roleId) {
        String url = url_PREFIX + "/menu/list?roleId=" + roleId;
        return restTemplate.getForObject(url, Result.class);
    }

}
