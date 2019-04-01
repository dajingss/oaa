package com.cn.services.impl;

import com.cn.model.dao.user.UserDao;
import com.cn.model.entity.user.User;
import com.cn.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public Map<String, Object> findUserOne(User user) {
        String msg = "用户不存在";
        Map map = new HashMap();
        List<User> userList = userDao.findByUserName(user.getUserName());
        if(userList.size() > 0) {
            msg="密码错误";
            if(user.getPassword().equals(userList.get(0).getPassword())) {
                msg = "登录成功";
                map.put("user",userList.get(0));
            }
        }
        map.put("msg",msg);
        return map;
    }
}
