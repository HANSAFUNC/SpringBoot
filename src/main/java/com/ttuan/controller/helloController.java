package com.ttuan.controller;
import Utils.IpUtil;
import Utils.TokenUtil;
import Utils.result.Responses;
import com.ttuan.entity.User;
import com.ttuan.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Api(value = "user",description = "测试")
@RestController
public class helloController {
    @Autowired
    private UserService userService;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @PostMapping("/login")
    public Responses<String> login(HttpServletRequest requset,String account,String pwd) {
        System.out.println(account);
        System.out.println(pwd);
        User user = userService.selectByAccount(account);
        Responses response;
        if (user == null) {
            response = Responses.ok("账号不存在");
        }else {
            System.out.println(user.getPwd());
            if (user.getPwd().equals(pwd)) {
                String token = TokenUtil.createJWT(user.getUid().toString(),user.getUserName());
                Map<String,String> map = new HashMap<String,String>();
                map.put("token",token);
                response = Responses.ok(map);
            }else {
                response = Responses.fail(503,"密码不正确");
            }

        }
        return response;
    }

    @GetMapping("/getAll")

    public Responses<List<User>> getAll(HttpServletRequest requset) {
        String token = requset.getHeader("token");
        if (token!=null) {
            TokenUtil.verifyToken(token);
        }
        System.out.println(IpUtil.getIpAddr(requset));
        return Responses.ok(userService.getUser());
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public Responses<User> addUser(String account) {
        System.out.println("1234");
        Responses response;
        User user = userService.selectByAccount(account);
        if (user == null) {
            System.out.println("注册成功");
            user = new User();
            user.setUserName(getRandomString(5));
            user.setAge(18);
            user.setUserHeadImg("http://img5.imgtn.bdimg.com/it/u=3300305952,1328708913&fm=26&gp=0.jpg");
            user.setAccount(account);
            user.setPwd("123456");
            userService.addUser(user);
            response = Responses.ok("注册成功");
        }else  {
            System.out.println("账号已存在");
            response = Responses.fail(400,"账号已存在");
        }

        return response;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public void deleteUserByUid(long uid) {
        System.out.println(uid);
        userService.deleteUser(uid);
    }
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public void update(@RequestParam(required = false) String userName ,
                       @RequestParam(required = false) String headImg,
                       @RequestParam(required = true)  Integer uid) {
        User user = new User();
        user.setUserHeadImg(headImg);
        user.setUserName(userName);

        System.out.println(user);

        userService.updateUser(user,uid);
    }

    public static String getRandomString(int length) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(3);
            long result = 0;
            switch (number) {
                case 0:
                    result = Math.round(Math.random() * 25 + 65);
                    sb.append(String.valueOf((char) result));
                    break;
                case 1:
                    result = Math.round(Math.random() * 25 + 97);
                    sb.append(String.valueOf((char) result));
                    break;
                case 2:
                    sb.append(String.valueOf(new Random().nextInt(10)));
                    break;
            }
        }
        return sb.toString();
    }
}



