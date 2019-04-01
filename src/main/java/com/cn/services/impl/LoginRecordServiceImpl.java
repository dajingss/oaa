package com.cn.services.impl;

import com.cn.model.dao.user.LoginRecordDao;
import com.cn.model.entity.user.LoginRecord;
import com.cn.services.LoginRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginRecordServiceImpl implements LoginRecordService {
    @Autowired
    private LoginRecordDao loginRecordDao;
    @Override
    public List<LoginRecord> loginRecordList() {
        return loginRecordDao.findAll();
    }
}
