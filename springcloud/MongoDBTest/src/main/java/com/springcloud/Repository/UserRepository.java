package com.springcloud.Repository;

import com.springcloud.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    // 可根据需要添加自定义的查询方法
    List<User> findByNo(String no);

    Optional<User> findByNoAndPassword(String no, String password);

    List<User> findByNameLike(String name);

    List<User> findByNameLike(String name, Pageable pageable);

    List<User> findByNameLike(String nameKeyword, PageRequest pageRequest);

    Page<User> findByRoleId(int parseInt, PageRequest pageRequest);

    Page<User> findByRoleIdAndNameContaining(Long roleId, String name, Pageable pageable);

}
