package com.example.searchact.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.searchact.Users.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface UserDao extends CrudRepository<User, Integer>,JpaRepository<User, Integer>{
    User findByUserId(int userid);

    List<User> findByUsername(String username);

    User findByUsernameAndPassword(String username,String password);

    List<User> findByEmail(String email);

}
