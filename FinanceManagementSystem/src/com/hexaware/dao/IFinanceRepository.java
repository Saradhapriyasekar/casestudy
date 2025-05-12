package com.hexaware.dao;

import java.util.List;

import com.hexaware.entity.Expense;
import com.hexaware.entity.User;

public interface IFinanceRepository {
	boolean createUser(User user);
	boolean createExpense(Expense expense);
	boolean deleteUser(int userId);
	boolean deleteExpense(int expenseId);
	List<Expense> getAllExpenses(int userId);
	boolean updateExpense(int userId , Expense expense);

}
