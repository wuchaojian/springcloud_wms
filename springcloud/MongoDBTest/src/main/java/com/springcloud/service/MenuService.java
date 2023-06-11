package com.springcloud.service;

import com.springcloud.pojo.Menu;

import java.util.List;
import java.util.Optional;

public interface MenuService {
    List<Menu> getAllMenus();

    Optional<Menu> getMenuByMenuId(int menuId);

    Menu createMenu(Menu menu);

    void deleteMenu(int menuId);

    Menu updateMenu(Menu menu);
}
