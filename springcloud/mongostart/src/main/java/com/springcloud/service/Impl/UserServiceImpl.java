package com.springcloud.service.Impl;

import com.springcloud.Repository.UserRepository;
import com.springcloud.common.QueryPageParam;
import com.springcloud.common.Result;
import com.springcloud.pojo.User;
import com.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public Result findByNo(String no) {
        List<User> userList = userRepository.findByNo(no);
        return userList.size() > 0 ? Result.suc(userList) : Result.fail();
    }

    @Override
    public Result save(User user) {
        User savedUser = userRepository.save(user);
        return savedUser != null ? Result.suc() : Result.fail();
    }

    @Override
    public Result update(User user) {
        User updatedUser = userRepository.save(user);
        return updatedUser != null ? Result.suc() : Result.fail();
    }

    @Override
    public Result del(String id) {
        try {
            userRepository.deleteById(id);
            return Result.suc();
        } catch (Exception e) {
            return Result.fail();
        }
    }

    @Override
    public Result login(User user) {
        return null;
    }

//    @Override
//    public Result login(User user) {
//        List<User> userList = userRepository.findByNoAndPassword(user.getNo(), user.getPassword());
//        if (userList.size() > 0) {
//            User user1 = userList.get(0);
//            List<Menu> menuList = menuService.lambdaQuery().like(Menu::getMenuright, user1.getRoleId()).list();
//            HashMap<String, Object> res = new HashMap<>();
//            res.put("user", user1);
//            res.put("menu", menuList);
//            return Result.suc(res);
//        }
//        return Result.fail();
//    }

    @Override
    public boolean mod(User user) {
        return userRepository.save(user) != null;
    }

    @Override
    public boolean saveOrMod(User user) {
        return userRepository.save(user) != null;
    }

    @Override
    public boolean delete(Integer id) {
        try {
            userRepository.deleteById(id.toString());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Result listP(User user) {
        return null;
    }

    @Override
    public List<User> listPage(QueryPageParam query) {
        return null;
    }

    @Override
    public List<User> listPageC(QueryPageParam query) {
        return null;
    }

    @Override
    public Collection<User> listPageC1(QueryPageParam query) {
        return null;
    }


}
