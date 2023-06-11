package com.springcloud.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springcloud.api.Products;

public interface ProductsService extends IService<Products> {

    IPage pageCC(IPage<Products> page,  Wrapper wrapper);
}
