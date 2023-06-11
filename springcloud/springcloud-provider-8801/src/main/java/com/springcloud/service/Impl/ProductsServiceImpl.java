package com.springcloud.service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.api.Products;
import com.springcloud.mapper.ProductsMapper;
import com.springcloud.service.ProductsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductsServiceImpl extends ServiceImpl<ProductsMapper, Products> implements ProductsService {

    @Resource
    private ProductsMapper productsMapper;


    @Override
    public IPage pageCC(IPage<Products> page, Wrapper wrapper) {
        {
            return productsMapper.pageCC(page,wrapper);

}}}
