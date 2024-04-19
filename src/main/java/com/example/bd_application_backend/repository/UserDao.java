package com.example.bd_application_backend.repository;

import com.example.bd_application_backend.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// 添加一些访问数据库的方法(这里添加的是根据用户名查询用户方法)
//接口要继承JpaRepository，这样JPA就能帮助我们完成对数据库的映射
@Repository
public interface UserDao extends JpaRepository<User, String> {
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
//    @Query(value = "select * from user where uname LIKE ?1 OR email LIKE ?2 OR lastdid LIKE ?3 OR uid LIKE ?4",nativeQuery = true)
//    @Query(value = "select * from users where username = user",nativeQuery = true)
//    Page<User> findMyUsers(
//            String uname,
//            String email,
//            String lastdid,
//            String uid,
//            Pageable request
//    );
}
