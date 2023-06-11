package com.springcloud.service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.api.Menu;
import com.springcloud.mapper.MenuMapper;
import com.springcloud.service.MenuService;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

}
