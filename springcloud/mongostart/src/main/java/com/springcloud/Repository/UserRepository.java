package com.springcloud.Repository;

import com.springcloud.pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    // 可根据需要添加自定义的查询方法
    List<User> findByNo(String no);

    List<User> findByNoAndPassword(String no, String password);
}
