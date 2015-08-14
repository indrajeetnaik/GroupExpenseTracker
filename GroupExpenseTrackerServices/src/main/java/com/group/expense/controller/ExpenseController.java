/**
 * 
 */
package com.group.expense.controller;

import com.group.expense.dao.ExpenseDao;
import com.group.expense.model.Expense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author AKivanda
 *
 */
@Path("/expense/")
@Component
public class ExpenseController {

    @Autowired
    private ExpenseDao expenseDao;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("addexpense")
    public Expense addExpense(Expense expense) {
        expenseDao.addExpense(expense);
        return expense;
    }

    @GET
    @Path("{groupName}/getExpenses")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Expense> getAllExpenses(@PathParam("groupName") String groupName) {
        return expenseDao.getAllExpenses(groupName);
    }
}
