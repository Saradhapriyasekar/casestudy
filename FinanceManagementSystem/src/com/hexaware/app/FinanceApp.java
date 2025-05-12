package com.hexaware.app;

import java.util.Scanner;
import com.hexaware.entity.User;
import com.hexaware.entity.Expense;
import java.util.List;

import com.hexaware.dao.FinanceRepositoryImpl;

public class FinanceApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        FinanceRepositoryImpl financeRepo = new FinanceRepositoryImpl();
        
        System.out.println("=== Welcome to the Finance Management App ===");
        
        while (true) {
            System.out.println("\n1. Create User\n2. Add Expense\n3. View Expenses\n4. Delete User\n5. Delete Expense\n6. Update Expense\n7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            
            switch (choice) {
            case 1:
                User user = new User();
                System.out.print("Enter User ID: ");
                user.setUserId(scanner.nextInt());
                scanner.nextLine(); // consume newline
                System.out.print("Enter Username: ");
                user.setUserName(scanner.nextLine());
                System.out.print("Enter Password: ");
                user.setPassword(scanner.nextLine());
                System.out.print("Enter Email: ");
                user.setEmail(scanner.nextLine());
                System.out.println(financeRepo.createUser(user) ? "User created." : "User creation failed.");
                break;
                
                
            case 2:
                Expense expense = new Expense();
                System.out.print("Enter Expense ID: ");
                expense.setExpenseId(scanner.nextInt());
                System.out.print("Enter User ID: ");
                expense.setUserId(scanner.nextInt());
                System.out.print("Enter Category ID: ");
                expense.setCategoryId(scanner.nextInt());
                System.out.print("Enter Amount: ");
                expense.setAmount(scanner.nextDouble());
                scanner.nextLine(); // consume newline
                System.out.print("Enter Description: ");
                expense.setDescription(scanner.nextLine());
                System.out.println(financeRepo.createExpense(expense) ? "Expense added." : "Expense addition failed.");
                break;
                
                
            case 3:
                System.out.print("Enter User ID to view expenses: ");
                int userId = scanner.nextInt();
                List<Expense> expenses = financeRepo.getAllExpenses(userId);
                if (expenses.isEmpty()) {
                    System.out.println("No expenses found.");
                } else {
                    for (Expense exp : expenses) {
                        System.out.println(exp);
                    }
                }
                break;
                
                
            case 4:
                System.out.print("Enter User ID to delete: ");
                int deleteId = scanner.nextInt();
                System.out.println(financeRepo.deleteUser(deleteId) ? "User deleted." : "User deletion failed.");
                break;
                
                
            case 5:
                System.out.print("Enter Expense ID to delete: ");
                int expenseId = scanner.nextInt();
                System.out.println(financeRepo.deleteExpense(expenseId) ? "Expense deleted." : "Expense deletion failed.");
                break;
                
                
                
            case 6:
                Expense updateExpense = new Expense();
                System.out.print("Enter User ID: ");
                int uid = scanner.nextInt();
                System.out.print("Enter Expense ID: ");
                updateExpense.setExpenseId(scanner.nextInt());
                System.out.print("Enter New Category ID: ");
                updateExpense.setCategoryId(scanner.nextInt());
                System.out.print("Enter New Amount: ");
                updateExpense.setAmount(scanner.nextDouble());
                scanner.nextLine();
                System.out.print("Enter New Description: ");
                updateExpense.setDescription(scanner.nextLine());
                System.out.println(financeRepo.updateExpense(uid, updateExpense) ? "Expense updated." : "Update failed.");
                break;
                
                
            case 7:
                System.out.println("Thank you for using the app.");
                scanner.close();
                System.exit(0);
                break;

            default:
                System.out.println("Invalid choice.");
            }
        }
                

	}

}
