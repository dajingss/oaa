package com.cn.services;

import com.cn.model.entity.user.Dept;

import java.util.List;

public interface Deptservice {

    public List<Dept> deptList();

    public void add(Dept dept);

    public void delete(Long id);

    public Dept findOne(Long id);

    public void edit(Dept dept);
}
