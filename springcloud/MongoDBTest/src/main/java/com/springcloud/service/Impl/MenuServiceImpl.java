package com.springcloud.service.Impl;

import com.springcloud.pojo.Menu;
import com.springcloud.Repository.MenuRepository;
import com.springcloud.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {
    private final MenuRepository menuRepository;

    @Autowired
    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Optional<Menu> getMenuByMenuId(int menuId) {
        return menuRepository.findByMenuId(menuId);
    }

    public Menu createMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public void deleteMenu(int menuId) {
        menuRepository.deleteByMenuId(menuId);
    }

    public Menu updateMenu(Menu menu) {
        return menuRepository.save(menu);
    }
}
