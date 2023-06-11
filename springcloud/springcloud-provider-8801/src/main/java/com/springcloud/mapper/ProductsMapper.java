package com.springcloud.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.springcloud.api.Products;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface ProductsMapper extends BaseMapper<Products> {

    IPage pageCC(IPage<Products> page, @Param(Constants.WRAPPER)Wrapper wrapper);
}
