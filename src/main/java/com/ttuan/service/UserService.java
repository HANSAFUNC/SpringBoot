package com.ttuan.service;

import Utils.result.Responses;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ttuan.mapper.UserMapper;
import org.springframework.stereotype.Service;
import com.ttuan.entity.User;

import java.util.List;
@Service
public class UserService extends ServiceImpl<UserMapper,User> {

    public User selectByAccount(String account) {
        EntityWrapper<User> warpper  = new EntityWrapper<User>();
        warpper.eq("account",account);
        return  selectOne(warpper);

    }

    public List<User> getUser() {
        return baseMapper.getUser();
    }

    public Responses<User> addUser(User user) {
         Integer ret = baseMapper.insert(user);
         if (ret == 1) {

         }
        return Responses.ok(user);
//         return Responses.fail(999,"插入失败");
    }
    public Responses deleteUser(long uid) {
        Responses responese;
        EntityWrapper<User> warpper = new EntityWrapper<User>();
        warpper.eq("uid",uid);
       int ret = baseMapper.delete(warpper);
       if (ret == 1) {
           responese = Responses.ok();
       }else {
           responese = Responses.fail();
       }
       return responese;
    }
    public Responses updateUser(User user,String uid) {
        Responses responese;
        EntityWrapper<User> warpper = new EntityWrapper<User>();
        warpper.eq("uid",uid);

       int ret = baseMapper.update(user,warpper);
       if (ret == 1){
           responese = Responses.ok();
       }else {
           responese = Responses.fail();
       }
       return responese;
    }

}
