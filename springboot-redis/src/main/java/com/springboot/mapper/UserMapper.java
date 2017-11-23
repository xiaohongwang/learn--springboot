package com.springboot.mapper;

import com.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xiaohong on 2017/11/15.
 */
public interface UserMapper extends JpaRepository<User,Integer>{
    User findByUserName(String userName);

    Long deleteById(Long id);

}
