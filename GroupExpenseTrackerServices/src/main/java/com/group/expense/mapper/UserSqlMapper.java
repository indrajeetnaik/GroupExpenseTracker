/**
 * 
 */
package com.group.expense.mapper;

import com.group.expense.model.User;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author AKivanda
 *
 */
@Component
public interface UserSqlMapper {

    public int addUser(@Param("user") User user);

    public List<User> getAllUsers();

}
