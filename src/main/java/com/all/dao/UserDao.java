package com.all.dao;

import com.all.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {

//    int deleteByPrimaryKey(Integer id);
//
//    int insert(User record);
//
//    int insertSeletive(User record);
//
//    User selectByPrimaryKey(Integer id);
//
//    List<User> selectAll();
//
//    int updateByPrimaryKeySelective(User record);
//
//    int updateByPrimaryKey(User record);

    @Select("select * from users where username = #{username} and password = #{password}")
    User selectByUsernameAndPassword(User user);

}
