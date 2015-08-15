/**
 * 
 */
package com.group.expense.dao;

import com.group.expense.mapper.GroupSqlMapper;
import com.group.expense.model.Group;
import com.group.expense.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author AKivanda
 *
 */
@Component
public class GroupDao {

    @Autowired
    private GroupSqlMapper groupSqlMapper;

    public List<Group> getAllGroupsOfUser(String userName) {
        return groupSqlMapper.getAllGroupsOfUser(userName);
    }

    public int createGroup(Group group) {
        return groupSqlMapper.createGroup(group);
    }

    public int addUserToGroup(User user, Integer groupId, int isAdmin) throws Exception {
        int inserted = 0;
        try {
            inserted = groupSqlMapper.addUserToGroup(user, groupId, isAdmin);
        }
        catch (Exception e) {
            throw new Exception("User is already added to group");
        }
        return inserted;
    }

    public int deleteUserFromGroup(Group group) {
        return groupSqlMapper.deleteUserFromGroup(group);
    }

    public Group getGroupByGroupName(String groupName) {
        return groupSqlMapper.getGroupByGroupName(groupName);
    }

}
