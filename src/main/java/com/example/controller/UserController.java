package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(description = "人员管理")
public class UserController {

    @Autowired
    private UserService userService;

    //新增
    @ApiOperation(notes = "新增1",value = "新增")
    @ApiImplicitParams({@ApiImplicitParam(name = "data",value = "{\"userName\":\"名字\",\"age\":\"年龄\",\"sex\":\"性别\"}",dataType = "String",required = true)})
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
