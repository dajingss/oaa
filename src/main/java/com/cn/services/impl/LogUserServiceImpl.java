package com.cn.services.impl;

import com.cn.model.dao.user.LogUserDao;
import com.cn.model.entity.user.User;
import com.cn.services.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LogUserServiceImpl implements LoginUserService {
    @Autowired
    private LogUserDao userdao;
    @Override
    public Map<String, Object> loginCheck(User user) {
        Map<String, Object> map = new HashMap<>();
        String str = "用户名不存在";
        List<User> userList = userdao.findAllByUserName(user.getUserName());
        if(userList != null && userList.size() >0){
            str = "密码错误";
            User u = userList.get(0);
            if(u.getPassword().equals(user.getPassword())){
                str = "登录成功";
//				向map中添加参数，使用put方法  map.put(key,value)
                map.put("userObj", u);

            }
        }
        map.put("msg", str);
        return map;
    }
}
