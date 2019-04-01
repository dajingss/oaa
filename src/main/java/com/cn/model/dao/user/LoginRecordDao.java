package com.cn.model.dao.user;

import com.cn.model.entity.user.LoginRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRecordDao extends JpaRepository<LoginRecord,Long> {

}
