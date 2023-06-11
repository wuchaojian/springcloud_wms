package com.springcloud.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springcloud.api.Products;
import com.springcloud.common.QueryPageParam;
import com.springcloud.common.Result;
import com.springcloud.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductsService productsService;
    //新增
    @PostMapping("/save")
    public Result save(@RequestBody Products products){
        return productsService.save(products)?Result.suc():Result.fail();
    }
    //更新
    @PostMapping("/update")
    public Result update(@RequestBody Products products){
        return productsService.updateById(products)?Result.suc():Result.fail();
    }
    //删除
    @GetMapping("/del")
    public Result del(@RequestParam String pid){
        return productsService.removeById(pid)?Result.suc():Result.fail();
    }

    @PostMapping("/listP")
    public Result listPageC1(@RequestBody QueryPageParam query) {

        HashMap param = query.getParam();
        String pName = (String) param.get("pName");
        String pType = (String) param.get("pType");
        String pWarehouse = (String) param.get("pWarehouse");
        String pManage = (String) param.get("pManage");
        String pTime = (String) param.get("pTime");
//        System.out.println("name==="+query.getParam().get("name"));
        Page<Products> page = new Page();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        LambdaQueryWrapper<Products> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(pName) ) {
            lambdaQueryWrapper.like(Products::getPname, pName);
        }
        if (StringUtils.isNotBlank(pType) ) {
            lambdaQueryWrapper.eq (Products::getPtype, pType);
        }if (StringUtils.isNotBlank(pManage) ) {
            lambdaQueryWrapper.like(Products::getPmanage, pManage);
        }if (StringUtils.isNotBlank(pTime) ) {
            lambdaQueryWrapper.eq(Products::getPtime, pTime);
        }
        if (StringUtils.isNotBlank(pWarehouse) ) {
            lambdaQueryWrapper.eq(Products::getPwarehouse, pWarehouse);
        }

//        IPage result = userService.pageC(page);
        IPage result = productsService.pageCC(page, lambdaQueryWrapper);
        System.out.println("total==" + result.getTotal());
        return Result.suc(result.getRecords(), result.getTotal());
    }
}
