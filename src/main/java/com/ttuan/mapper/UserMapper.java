package com.ttuan.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ttuan.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Results({
//            @Result(property = "uid",column = "uid"),
            @Result(property = "userName",column = "user_name"),
//            @Result(property = "age",column = "age"),
    })

    @Select("SELECT * FROM user")
    public List<User>  getUser();

//    @Select("SELECT * FROM user WHERE uid = #{uid}")
//    public User getUserByUid(int uid);
//
//    @Insert("INSERT INTO user(userName, age) VALUES (#{userName}, #{age})")
//    public void addUser(User user);
//
//    @Delete("DELETE FROM user WHERE uid = #{uid}")
//    public void deleteUser(int uid);
}
