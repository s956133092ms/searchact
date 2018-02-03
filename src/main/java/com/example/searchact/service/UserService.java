package com.example.searchact.service;

import com.example.searchact.Users.User;
import com.example.searchact.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface UserService {

    List<User> all();

    User selectbyuserid(int userid);

    List<User> selectbyusername(String username);

    User selectbyusernameandpassword(String username,String password);

    List<User> selectbyemail(String email);

    User save(User user);
}
