package com.example.searchact.controller;

import com.example.searchact.Users.User;
import com.example.searchact.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userservice;

    @RequestMapping(value="/findall")
    public List<User> all(){
        return userservice.all();
    }

    @RequestMapping(value="findid")
    public User userid(int userid){
        return userservice.selectbyuserid(userid);
    }

    @RequestMapping(value="/login")
    public Map login(String username, String password){
        Map map = new HashMap();
        User user = userservice.selectbyusernameandpassword(username,password);
        map.put("data",user);
        if(user==null) map.put("stu","fail");
        else map.put("stu","success");
        return map;
    }

    @RequestMapping(value="/adduser")
    public Object addUser(User user){
        List<User> list = userservice.selectbyusername(user.getUsername());
        if(list!=null) return "repeat";
        else {
            User add = new User();
            add.setUsername(user.getUsername());
            add.setPassword(user.getPassword());
            add.setEmail(user.getEmail());
            add.setEx(0);
            add.setLevel(0);
            add.setPower(2);
            User result = userservice.save(add);
            if(result!=null) return "success";
            else return "fail";
        }//else
    }//public
}
