package BankingSystem.service;

import BankingSystem.entity.BankAccount;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<BankAccount> accounts;
    private List<String> transactionLog;

    public Bank() {
        accounts = new ArrayList<>();
        transactionLog = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
        System.out.println("Đã thêm tài khoản: " + account.getAccountNumber());
    }

    public BankAccount findAccount(String accountNumber) {
        for (BankAccount a : accounts)
            if (a.getAccountNumber().equals(accountNumber))
                return a;
        return null;
    }

    public void deposit(String accountNumber, double amount) {
        BankAccount acc = findAccount(accountNumber);
        if (acc != null) {
            acc.deposit(amount);
            transactionLog.add("Nạp " + amount + " vào tài khoản " + accountNumber);
        } else {
            System.out.println("Không tìm thấy tài khoản.");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        BankAccount acc = findAccount(accountNumber);
        if (acc != null) {
            if (acc.withdraw(amount)) {
                transactionLog.add("Rút " + amount + " từ tài khoản " + accountNumber);
            }
        } else {
            System.out.println("Không tìm thấy tài khoản.");
        }
    }

    public double getTotalBalance() {
        double total = 0;
        for (BankAccount acc : accounts) {
            total += acc.getBalance();
        }
        return total;
    }

    public void applyInterestToAll() {
        for (BankAccount acc : accounts) {
            acc.calculateInterest();
        }
    }

    public void printTransactionLog() {
        System.out.println("===== Nhật ký giao dịch =====");
        for (String log : transactionLog) {
            System.out.println(log);
        }
    }
}
