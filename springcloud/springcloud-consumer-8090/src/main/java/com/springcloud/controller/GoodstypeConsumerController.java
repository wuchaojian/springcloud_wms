package com.springcloud.controller;

import com.springcloud.api.Goodstype;
import com.springcloud.common.QueryPageParam;
import com.springcloud.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/goodstype")
public class GoodstypeConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    //通过服务名来获取url
    private static final String url_PREFIX="http://springcloud-provider-type";
    @PostMapping("/save")
    public Result saveGoodstype(@RequestBody Goodstype goodstype) {
        String url = url_PREFIX + "/goodstype/save";
        return restTemplate.postForObject(url, goodstype, Result.class);
    }

    @PostMapping("/update")
    public Result updateGoodstype(@RequestBody Goodstype goodstype) {
        String url = url_PREFIX + "/goodstype/update";
        return restTemplate.postForObject(url, goodstype, Result.class);
    }

    @GetMapping("/del")
    public Result deleteGoodstype(@RequestParam String id) {
        String url = url_PREFIX + "/goodstype/del?id=" + id;
        return restTemplate.getForObject(url, Result.class);
    }

    @PostMapping("/listPage")
    public Result listPage(@RequestBody QueryPageParam query) {
        String url = url_PREFIX + "/goodstype/listPage";
        return restTemplate.postForObject(url, query, Result.class);
    }

    @GetMapping("/list")
    public Result listGoodstypes() {
        String url = url_PREFIX + "/goodstype/list";
        return restTemplate.getForObject(url, Result.class);
    }


}
