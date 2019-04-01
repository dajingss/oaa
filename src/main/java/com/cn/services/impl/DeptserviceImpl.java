package com.cn.services.impl;

import com.cn.model.dao.user.DeptDao;
import com.cn.model.entity.user.Dept;
import com.cn.services.Deptservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptserviceImpl implements Deptservice {

    @Autowired
    private DeptDao deptDao;


    @Override
    public List<Dept> deptList() {
        return deptDao.findAll();
    }

    @Override
    public void add(Dept dept) {
        deptDao.save(dept);
    }

    @Override
    public void delete(Long id) {
        deptDao.delete(id);
    }

    @Override
    public Dept findOne(Long id) {
        return deptDao.findOne(id);
    }

    @Override
    public void edit(Dept dept) {
        deptDao.save(dept);
    }
}
