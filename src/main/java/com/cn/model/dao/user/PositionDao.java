package com.cn.model.dao.user;

import com.cn.model.entity.user.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionDao extends JpaRepository<Position,Long> {
}
