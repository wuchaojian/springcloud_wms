package com.springcloud.controller;

import com.springcloud.api.Record;
import com.springcloud.common.QueryPageParam;
import com.springcloud.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/record")
public class RecordConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    //通过服务名来获取url
    private static final String url_PREFIX="http://springcloud-provider-record";

    @PostMapping("/listPage")
    public Result listPage(@RequestBody QueryPageParam query) {
        return restTemplate.postForObject(url_PREFIX + "/record/listPage", query, Result.class);
    }

    @PostMapping("/save")
    public Result save(@RequestBody Record record) {
        return restTemplate.postForObject(url_PREFIX + "/record/save", record, Result.class);
    }
}
