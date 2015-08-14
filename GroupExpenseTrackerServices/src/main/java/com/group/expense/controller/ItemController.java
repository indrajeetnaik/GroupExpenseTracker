/**
 * 
 */
package com.group.expense.controller;

import com.group.expense.dao.ItemDao;
import com.group.expense.model.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author AKivanda
 *
 */
@Component
@Path("/item/")
public class ItemController {

    @Autowired
    private ItemDao itemDao;

    @GET
    @Path("getallitems")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Item> getAllItems() {
        return itemDao.getAllItems();
    }
}
