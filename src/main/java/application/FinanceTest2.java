package application;

import dao.AccountDAO;
import dao.CategoryDAO;
import dao.TransactionDAO;
import entities.Account;
import entities.Category;
import entities.Transaction;

import java.util.Date;
import java.util.Scanner;

public class FinanceTest2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a transaction id: ");
        int transactionId = scanner.nextInt();

        TransactionDAO transactionDAO = new TransactionDAO();
        Transaction transaction = transactionDAO.getTransaction(transactionId);

        System.out.println("Transaction details: ");
        System.out.println(transaction);

    }
}

