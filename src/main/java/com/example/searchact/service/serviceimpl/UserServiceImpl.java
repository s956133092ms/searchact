package com.example.searchact.service.serviceimpl;

import com.example.searchact.Users.User;
import com.example.searchact.dao.UserDao;
import com.example.searchact.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userdao;

    public List<User> all(){
        List<User> list = userdao.findAll();
        return list;
    }

    public User selectbyuserid(int userid){
        User user = userdao.findByUserId(userid);
        return user;
    }

    public List<User> selectbyusername(String username){
        List<User> list = userdao.findByUsername(username);
        return list;
    }

    public User selectbyusernameandpassword(String username,String password){
        User user = userdao.findByUsernameAndPassword(username,password);
        return user;
    }

    public List<User> selectbyemail(String email){
        List<User> list = userdao.findByEmail(email);
        return list;
    }

    public User save(User user){
        return userdao.save(user);
    }
}
