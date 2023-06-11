package com.springcloud.Repository;

import com.springcloud.pojo.Menu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends MongoRepository<Menu, String> {
    // 自定义查询方法
    Optional<Menu> findByMenuId(int menuId);

    void deleteByMenuId(int menuId);

    List<Menu> findByMenurightContaining(String menuright);

}
