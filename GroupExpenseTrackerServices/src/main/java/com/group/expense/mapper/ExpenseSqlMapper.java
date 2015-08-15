/**
 * 
 */
package com.group.expense.mapper;

import com.group.expense.model.Expense;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author AKivanda
 *
 */
@Component
public interface ExpenseSqlMapper {

    int addExpense(@Param("expense") Expense expense);

    List<Expense> getAllExpenses(@Param("groupName") String groupName);

}
