package com.cn.services.impl;

import com.cn.model.dao.user.PositionDao;
import com.cn.model.entity.user.Position;
import com.cn.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionServiceImpl implements PositionService{
    @Autowired
    private PositionDao positionDao;
    @Override
    public List<Position> positionList() {
        return positionDao.findAll();
    }

    @Override
    public void add(Position position) {
        positionDao.save(position);
    }

    @Override
    public Position findOneById(Long id) {
        return positionDao.findOne(id);
    }

    @Override
    public void edit(Position position) {
        positionDao.save(position);
    }
}
