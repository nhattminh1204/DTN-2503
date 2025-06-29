package BankingSystem.entity;

public class CheckingAccount extends BankAccount{
    private double withdrawLimit;

    public CheckingAccount(String accountNumber, String ownerName, double balance, double withdrawLimit) {
        super(accountNumber, ownerName, balance);
        this.withdrawLimit = withdrawLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= getBalance() && amount <= withdrawLimit) {
            setBalance(getBalance() - amount);
            System.out.println("Đã rút " + amount + " từ tài khoản thanh toán " + getAccountNumber());
            return true;
        } else {
            System.out.println("Rút tiền thất bại: vượt hạn mức hoặc không đủ số dư.");
            return false;
        }
    }

    @Override
    public void calculateInterest() {
        System.out.println("Tài khoản thanh toán " + getAccountNumber() + " không có lãi suất.");
    }
}
