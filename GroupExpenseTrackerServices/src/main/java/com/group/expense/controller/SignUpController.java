/**
 * 
 */
package com.group.expense.controller;

import com.group.expense.dao.UserDao;
import com.group.expense.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author AKivanda
 *
 */
@Component
@Path("/user/")
public class SignUpController {

    @Autowired
    private UserDao userDao;

    @POST
    @Path("signupuser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response signUpUser(User user) {
        userDao.addUser(user);
        return Response.status(200).entity(true).build();
    }

    @GET
    @Path("allusers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

}
