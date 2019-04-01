package com.cn.services;

import com.cn.model.entity.user.User;

import java.util.Map;

public interface LoginUserService {
    /**
     * 查询
     * @return
     */
    public Map<String, Object> loginCheck(User user);
}
