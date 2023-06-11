package com.springcloud.service.Impl;

import com.springcloud.Repository.MenuRepository;
import com.springcloud.Repository.UserRepository;
import com.springcloud.common.QueryPageParam;
import com.springcloud.common.Result;
import com.springcloud.pojo.Menu;
import com.springcloud.pojo.User;
import com.springcloud.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private MenuRepository menuRepository;

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
        Optional<User> optionalUser = userRepository.findByNoAndPassword(user.getNo(), user.getPassword());
        if (optionalUser.isPresent()) {
            User user1 = optionalUser.get();
            // 进行菜单查询等操作
            List<Menu> menuList = menuRepository.findByMenurightContaining(String.valueOf(user1.getRoleId()));
            HashMap<String, Object> res = new HashMap<>();
            res.put("user", user1);
            res.put("menu", menuList);
            System.out.println(res.get("menu"));
            return Result.suc(res);
        } else {
            return Result.fail();
        }
    }

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
        if (StringUtils.isNotBlank(user.getName())) {
            List<User> userList = userRepository.findByNameLike(user.getName());
            return Result.suc(userList);
        } else {
            return Result.fail();
        }
    }

    @Override
    public List<User> listPage(QueryPageParam query) {
        HashMap<String, Object> param = query.getParam();
        String name = (String) param.get("name");
        System.out.println("name===" + name);

        int pageNum = query.getPageNum();
        int pageSize = query.getPageSize();

        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        List<User> userList = userRepository.findByNameLike(name, pageable);

        System.out.println("total==" + userList.size());

        return userList;
    }

    @Override
    public List<User> listPageC(QueryPageParam query) {
        HashMap<String, Object> param = query.getParam();
        String name = (String) param.get("name");
        System.out.println("name===" + name);

        int pageNum = query.getPageNum();
        int pageSize = query.getPageSize();
        int skip = (pageNum - 1) * pageSize;

        List<User> userList = userRepository.findByNameLike(name, PageRequest.of(pageNum - 1, pageSize));

        return userList;
    }

    @Override
    public Result listPageC1(QueryPageParam query) {
        HashMap<String, Object> param = query.getParam();
        String name = (String) param.get("name");
        String sex = (String) param.get("sex");
        String roleId = (String) param.get("roleId");

        int pageNum = query.getPageNum();
        int pageSize = query.getPageSize();

        // 构建分页对象
        PageRequest pageRequest = PageRequest.of(pageNum - 1, pageSize);

        // 构建查询条件
        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
//        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());


        User user = new User();
        if (StringUtils.isNotBlank(name) && !"null".equals(name)) {
            user.setName(name);
        }
        if (StringUtils.isNotBlank(sex)) {
            user.setSex(Integer.parseInt(sex));
        }
        if (StringUtils.isNotBlank(roleId)) {
            user.setRoleId(Integer.parseInt(roleId));
        }

        Example<User> example = Example.of(user, matcher);
//        System.out.println(example);
        // 执行分页查询
        Page<User> page;
        if (StringUtils.isNotBlank(name)) {
            page = userRepository.findByRoleIdAndNameContaining(Long.parseLong(roleId), name, pageRequest);
        } else {
            page = userRepository.findByRoleId(Integer.parseInt(roleId), pageRequest);
        }

        List<User> userList = page.getContent();
        long total = page.getTotalElements();

        return Result.suc(userList, total);
    }

}
