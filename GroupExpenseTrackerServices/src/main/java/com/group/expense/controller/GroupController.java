package com.group.expense.controller;

import com.group.expense.dao.GroupDao;
import com.group.expense.dao.UserDao;
import com.group.expense.model.ErrorMessage;
import com.group.expense.model.Group;
import com.group.expense.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Component
@Path("/group/")
public class GroupController {

    @Autowired
    private GroupDao groupDao;

    @Autowired
    private UserDao userDao;

    @GET
    @Path("viewgroups/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Group> getAllGroupsOfUser(@PathParam("userName") String userName) {
        return groupDao.getAllGroupsOfUser(userName);
    }

    @POST
    @Path("creategroup")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createGroup(Group group) {
        Group dbGroup = groupDao.getGroupByGroupName(group.getGroupName());

        if (dbGroup != null) {
            ErrorMessage errorMessage = new ErrorMessage("GroupName already exists", 500, "Error");
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build();
        }
        else {
            groupDao.createGroup(group);
        }
        return Response.status(200).entity(group).build();
    }

    @POST
    @Path("addusertogroup")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUserToGroup(Group group) {
        for (User groupuser: group.getUsers()) {
            User user = userDao.getUserByUserName(groupuser.getUserName());
            Group dbGroup = groupDao.getGroupByGroupName(group.getGroupName());
            if (groupuser.getIsAdmin() == null) {
                groupuser.setIsAdmin(0);
            }
            try {
                groupDao.addUserToGroup(user, dbGroup.getGroupId(), groupuser.getIsAdmin());
            }
            catch (Exception e) {
                return Response.status(Response.Status.CONFLICT).entity("User already added to group").build();
            }
        }
        return Response.status(200).entity(true).build();
    }

    @DELETE
    @Path("deleteuserfromgroup")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteUserFromGroup(Group group) {
        groupDao.deleteUserFromGroup(group);
        return Response.status(200).entity(true).build();
    }
}
