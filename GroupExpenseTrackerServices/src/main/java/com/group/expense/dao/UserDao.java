/**
 * 
 */
package com.group.expense.dao;

import com.group.expense.mapper.UserSqlMapper;
import com.group.expense.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author AKivanda
 *
 */
@Component
public class UserDao {

    @Autowired
    private UserSqlMapper userSqlMapper;

    public int addUser(User user) {
        return userSqlMapper.addUser(user);
    }

    public List<User> getAllUsers() {
        return userSqlMapper.getAllUsers();
    }
}
