package com.springcloud.controller;

import com.springcloud.api.Storage;
import com.springcloud.common.QueryPageParam;
import com.springcloud.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/storage")
public class StorageConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    //通过服务名来获取url
    private static final String url_PREFIX="http://springcloud-provider-type";

    @PostMapping("/save")
    public Result saveStorage(@RequestBody Storage storage) {
        String url = url_PREFIX + "/storage/save";
        return restTemplate.postForObject(url, storage, Result.class);
    }

    @PostMapping("/update")
    public Result updateStorage(@RequestBody Storage storage) {
        String url = url_PREFIX + "/storage/update";
        return restTemplate.postForObject(url, storage, Result.class);
    }

    @GetMapping("/del")
    public Result deleteStorage(@RequestParam String id) {
        String url = url_PREFIX + "/storage/del?id=" + id;
        return restTemplate.getForObject(url, Result.class);
    }

    @PostMapping("/listPage")
    public Result listPage(@RequestBody QueryPageParam query) {
        String url = url_PREFIX + "/storage/listPage";
        return restTemplate.postForObject(url, query, Result.class);
    }

    @GetMapping("/list")
    public Result listStorages() {
        String url = url_PREFIX + "/storage/list";
        return restTemplate.getForObject(url, Result.class);
    }

}
