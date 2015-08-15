package com.expense.database;

import com.expense.model.Expense;
import com.expense.model.Group;
import com.expense.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kalmeshwar on 8/6/2015.
 */
public class ExpenseDatabase {

    private static Map<String, User> users = new HashMap<>();
    private static Map<Integer, Group> groups = new HashMap<>();
    private static Map<Integer, Expense> expenses = new HashMap<>();

    public static Map<String, User> getUsers() {
        return users;
    }

/*    public static void setUsers(Map<String, User> users) {
        this.users = users;
    }*/

    public static Map<Integer, Group> getGroups() {
        return groups;
    }

  /*  public static void setGroups(Map<Integer, Group> groups) {
        this.groups = groups;
    }*/

    public static Map<Integer, Expense> getExpenses() {
        return expenses;
    }

    /*public static void setExpenses(Map<Integer, Expense> expenses) {
        this.expenses = expenses;
    }*/
}
