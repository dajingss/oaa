package com.cn.services;

import com.cn.model.entity.user.User;

import java.util.Map;

public interface UserService {

    public Map<String , Object> findUserOne(User user);
}
