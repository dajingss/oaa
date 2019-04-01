package com.cn.model.dao.user;

import com.cn.model.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Long>{

    List<User> findByUserName(String userName);
}
