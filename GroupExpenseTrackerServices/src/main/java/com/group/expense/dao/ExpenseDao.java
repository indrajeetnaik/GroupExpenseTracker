/**
 * 
 */
package com.group.expense.dao;

import com.group.expense.mapper.ExpenseSqlMapper;
import com.group.expense.model.Expense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author AKivanda
 *
 */
@Component
public class ExpenseDao {

    @Autowired
    private ExpenseSqlMapper expenseSqlMapper;

    public int addExpense(Expense expense) {
        return expenseSqlMapper.addExpense(expense);
    }

    public List<Expense> getAllExpenses(String groupName) {
        return expenseSqlMapper.getAllExpenses(groupName);
    }

}
