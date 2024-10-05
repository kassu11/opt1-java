package application;

import dao.*;
import entity.Account;

import java.util.List;

public class Main {
    public static void main(String[] args) {
    	
    	Dao dao = new Dao();
        dao.addAccount(new Account(69, 123.45));
        dao.addAccount(new Account(420, 200.22));

        dao.transfer(69, 420, 50.39);

        Account account1 = dao.getAccount(69);
        Account account2 = dao.getAccount(420);

        System.out.println("Account 69 balance: " + account1.getBalance());
        System.out.println("Account 420 balance: " + account2.getBalance());
    }
}

