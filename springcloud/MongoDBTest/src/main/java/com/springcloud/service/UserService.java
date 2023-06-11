package com.springcloud.service;

import com.springcloud.common.QueryPageParam;
import com.springcloud.common.Result;
import com.springcloud.pojo.User;

import java.util.List;

public interface UserService {
    List<User> list();
    Result findByNo(String no);
    Result save(User user);
    Result update( User user);
    Result del( String id);
    Result login( User user);
    boolean mod(User user);
    boolean saveOrMod(User user);
    boolean delete(Integer id);
    Result listP(User user);
    List<User> listPage(QueryPageParam query);
    List<User> listPageC( QueryPageParam query);
    Result listPageC1(QueryPageParam query);
}
