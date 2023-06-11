package com.springcloud.controller;

import com.springcloud.api.Goods;
import com.springcloud.common.QueryPageParam;
import com.springcloud.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/goods")
public class GoodsConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    //通过服务名来获取url
    private static final String url_PREFIX="http://springcloud-provider-record";

    @PostMapping("/save")
    public Result save(@RequestBody Goods goods) {
        return restTemplate.postForObject(url_PREFIX + "/goods/save", goods, Result.class);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Goods goods) {
        return restTemplate.postForObject(url_PREFIX + "/goods/update", goods, Result.class);
    }

    @GetMapping("/del")
    public Result del(@RequestParam String id) {
        return restTemplate.getForObject(url_PREFIX + "/goods/del?id=" + id, Result.class);
    }

    @PostMapping("/listPage")
    public Result listPage(@RequestBody QueryPageParam query) {
        String url = url_PREFIX + "/goods/listPage";
        return restTemplate.postForObject(url, query, Result.class);
    }

}
