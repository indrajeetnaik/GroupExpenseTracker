/**
 * 
 */
package com.group.expense.mapper;

import com.group.expense.model.Group;
import com.group.expense.model.User;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author AKivanda
 *
 */
@Component
public interface GroupSqlMapper {

    List<Group> getAllGroupsOfUser(@Param("userName") String userName);

    int createGroup(@Param("group") Group group);

    int addUserToGroup(@Param("user") User user, @Param("groupId") Integer groupId, @Param("isAdmin") int isAdmin);

    int deleteUserFromGroup(@Param("group") Group group);

    Group getGroupByGroupName(@Param("groupName") String groupName);

}
