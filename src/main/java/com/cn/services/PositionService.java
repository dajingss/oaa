package com.cn.services;

import com.cn.model.entity.user.Position;

import java.util.List;

public interface PositionService {


    public List<Position> positionList();


    public void add(Position position);


    public Position findOneById(Long id);


    public void edit(Position position);
}
