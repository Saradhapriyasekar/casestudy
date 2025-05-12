package com.hexaware.test;

import com.hexaware.dao.FinanceRepositoryImpl;
import com.hexaware.entity.User;
import com.hexaware.entity.Expense;

import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FinanceRepositoryTest {

    static FinanceRepositoryImpl repo;

    @BeforeAll
    public static void setup() {
        repo = new FinanceRepositoryImpl();
    }

    @Test
    public void testCreateUser() {
        User user = new User(101, "testuser", "testpass", "test@example.com");
        boolean result = repo.createUser(user);
        assertTrue(result);
    }

    @Test
    public void testCreateExpense() {
    	Expense expense = new Expense(1, 101, 300.00, 5, LocalDate.now(), "Groceries");

        boolean result = repo.createExpense(exp);
        assertTrue(result);
    }

    @Test
    public void testGetAllExpenses() {
        List<Expense> list = repo.getAllExpenses(101);
        assertNotNull(list);
        assertTrue(list.size() >= 0); 
    }

    @Test
    public void testDeleteExpense() {
        boolean result = repo.deleteExpense(201);
        assertTrue(result);
    }

    @Test
    public void testDeleteUser() {
        boolean result = repo.deleteUser(101);
        assertTrue(result);
    }
}

