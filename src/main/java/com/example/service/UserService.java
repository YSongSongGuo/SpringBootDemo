package com.example.service;

import com.example.Repository.UserRepository;
import com.example.entity.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author Squirrel
 * @date 2019/4/24 15:05
 * @desc
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //新增
    public String add(String data){

        JSONObject jsonObject = new JSONObject(data);
        String userName = jsonObject.isNull("userName")?"":jsonObject.optString("userName");
        String sex = jsonObject.isNull("sex")?"":jsonObject.optString("sex");
        String age = jsonObject.isNull("age")?"0":jsonObject.optString("age");
        //实体类声明
        User user = new User();
        user.setUserName(userName);
        user.setSex(sex);
        user.setAge(Integer.valueOf(age));
        user.setCreatDate(new Date());
        user.setDelStatus(false);

        userRepository.save(user);
        return "添加成功！";
    }

    //编辑
    public String edit(String data){

        JSONObject jsonObject = new JSONObject(data);
        String id = jsonObject.isNull("id")?"":jsonObject.optString("id");
        String userName = jsonObject.isNull("userName")?"":jsonObject.optString("userName");
        String sex = jsonObject.isNull("sex")?"":jsonObject.optString("sex");
        String age = jsonObject.isNull("age")?"":jsonObject.optString("age");
        //根据id用户对象
        User user = userRepository.findOne(id.trim());
        if (user ==null){
            return "获取信息失败！";
        }
        if (!StringUtils.isEmpty(userName)){
            user.setUserName(userName);
        }
        if (!StringUtils.isEmpty(userName)){
            user.setSex(sex);
        }
        if (!StringUtils.isEmpty(userName)){
            user.setAge(Integer.valueOf(age));
        }

        userRepository.save(user);
        return "编辑成功！";
    }

    //删除
    public String del(String data){
        JSONObject jsonObject = new JSONObject(data);
        String id = jsonObject.isNull("id")?"":jsonObject.optString("id");
        //根据id用户对象
        User user = userRepository.findOne(id.trim());
        if (user ==null){
            return "获取信息失败！";
        }
        user.setDelStatus(true);
        userRepository.save(user);
        return "删除成功！";
    }


    //获取所有用户
    public List<User> list(){
        //根据id用户对象
        List<User> userList = userRepository.findAllByDelStatus(false);

        return userList;
    }

}
