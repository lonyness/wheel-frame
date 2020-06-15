package com.frame.wheel.wheelsystem.dao;

import com.frame.wheel.wheelsystem.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    User getOneByName(String name);


}
