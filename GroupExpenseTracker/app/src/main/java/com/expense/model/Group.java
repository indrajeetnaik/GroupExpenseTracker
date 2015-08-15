package com.expense.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kalmeshwar on 8/6/2015.
 */
public class Group implements Serializable{
    private long groupId;
    private String groupName;
    private String groupDesc;
    private List<User> members = new ArrayList<>();

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }
}
