package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Squirrel
 * @date 2019/4/24 15:06
 * @desc
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    //新增
    @PostMapping(value = "/add")
    public String add(@RequestBody String data){
        return  userService.add(data);
    }

    //编辑
    @PostMapping(value = "/edit")
    public String edit(@RequestBody String data){
        return  userService.edit(data);
    }

    //删除
    @PostMapping(value = "/del")
    public String del(@RequestBody String data){
        return  userService.del(data);
    }

    //获取所有用户
    @PostMapping(value = "/list")
    public List<User> list(){
        return  userService.list();
    }

}
