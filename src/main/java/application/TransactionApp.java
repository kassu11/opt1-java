package application;

import entities.Account;
import entities.Category;
import dao.*;
import entities.Transaction;

import java.util.Date;

public class TransactionApp {

    public static void main(String[] args) {
    	
    	AccountDAO accountDAO = new AccountDAO();
        CategoryDAO categoryDAO = new CategoryDAO();
        TransactionDAO transactionDAO = new TransactionDAO();
    	
        Account account1 = new Account("Checking", 1000);
        Account account2 = new Account("Savings", 5000);
        Category category1 = new Category("Groceries");

        accountDAO.saveAccount(account1);
        accountDAO.saveAccount(account2);
        categoryDAO.saveCategory(category1);
        Transaction transaction1 = new Transaction( 100, "Grocery shopping", new Date(), category1, account1, account2);
        Transaction transaction2 = new Transaction( 200, "Grocery shopping", new Date(), category1, account1, account2);

        transactionDAO.saveTransaction(transaction1);
        transactionDAO.saveTransaction(transaction2);
    }
}

