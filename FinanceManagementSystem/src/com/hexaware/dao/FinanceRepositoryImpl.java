package com.hexaware.dao;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.entity.Expense;
import com.hexaware.entity.User;
import com.hexaware.util.DBConnUtil;
import com.hexaware.util.DBPropertyUtil;

public class FinanceRepositoryImpl implements IFinanceRepository {
	private Connection getConnection() throws SQLException {
		String dbUrl = DBPropertyUtil.getPropertyString("db.properties");
		return DBConnUtil.getConnection(dbUrl);
		
	}
	
	@Override
	public boolean createUser(User user) {
		String sql = "INSERT INTO users (user_id, username, password, email) VALUES (?, ?, ?, ?)";
		try (Connection con = getConnection();
				PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, user.getUserId());
			pst.setString(2, user.getUserName());
			pst.setString(3, user.getPassword());
            pst.setString(4, user.getEmail());
            return pst.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
            return false;
		}
	}
	
	
	 @Override
	    public boolean createExpense(Expense expense) {
	        String sql = "INSERT INTO expenses (expense_id , user_id , amount , category_id , date , description) VALUES (?, ?, ?, ?, ? , ?)";
	        try (Connection con = getConnection();
	             PreparedStatement pst = con.prepareStatement(sql)) {
	            pst.setInt(1, expense.getExpenseId());
	            pst.setInt(2, expense.getUserId());
	            pst.setDouble(3, expense.getAmount());
	            pst.setInt(4, expense.getCategoryId());
	            pst.setDate(5, java.sql.Date.valueOf(expense.getDate()));
	            pst.setString(6, expense.getDescription());
	            return pst.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	 
	 
	 @Override
	    public boolean deleteUser(int userId) {
	        String sql = "DELETE FROM users WHERE user_id = ?";
	        try (Connection con = getConnection();
	             PreparedStatement pst = con.prepareStatement(sql)) {
	            pst.setInt(1, userId);
	            return pst.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	 
	 
	 @Override
	    public boolean deleteExpense(int expenseId) {
	        String sql = "DELETE FROM expenses WHERE expense_id = ?";
	        try (Connection con = getConnection();
	             PreparedStatement pst = con.prepareStatement(sql)) {
	            pst.setInt(1, expenseId);
	            return pst.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	 
	 
	 
	 @Override
	    public List<Expense> getAllExpenses(int userId) {
	        List<Expense> expenses = new ArrayList<>();
	        String sql = "SELECT * FROM expenses WHERE user_id = ?";
	        try (Connection con = getConnection();
	             PreparedStatement pst = con.prepareStatement(sql)) {
	            pst.setInt(1, userId);
	            ResultSet rs = pst.executeQuery();
	            while (rs.next()) {
	                Expense exp = new Expense();
	                exp.setExpenseId(rs.getInt("expense_id"));
	                exp.setUserId(rs.getInt("user_id"));
	                exp.setCategoryId(rs.getInt("category_id"));
	                exp.setAmount(rs.getDouble("amount"));
	                exp.setDescription(rs.getString("description"));
	                expenses.add(exp);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return expenses;
	    }
	 
	 
	 
	 @Override
	    public boolean updateExpense(int userId, Expense expense) {
	        String sql = "UPDATE expenses SET category_id=?, amount=?, description=? WHERE expense_id=? AND user_id=?";
	        try (Connection con = getConnection();
	             PreparedStatement pst = con.prepareStatement(sql)) {
	            pst.setInt(1, expense.getCategoryId());
	            pst.setDouble(2, expense.getAmount());
	            pst.setString(3, expense.getDescription());
	            pst.setInt(4, expense.getExpenseId());
	            pst.setInt(5, userId);
	            return pst.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	

}
