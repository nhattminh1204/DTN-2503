package BankingSystem;

import BankingSystem.entity.SavingsAccount;
import BankingSystem.entity.CheckingAccount;
import BankingSystem.service.Bank;

public class BankiManagement {
    private Bank bank;

    public BankiManagement() {
        bank = new Bank();
    }

    public void data() {
        // Tạo tài khoản tiết kiệm (SavingsAccount)
        SavingsAccount sa1 = new SavingsAccount("SA001", "Nguyễn Văn A", 5000);
        SavingsAccount sa2 = new SavingsAccount("SA002", "Lê Thị B", 10000);
        SavingsAccount sa3 = new SavingsAccount("SA003", "Phạm Văn C", 7500);

        // Tạo tài khoản thanh toán (CheckingAccount)
        CheckingAccount ca1 = new CheckingAccount("CA001", "Trần Thị D", 3000, 1000);
        CheckingAccount ca2 = new CheckingAccount("CA002", "Đỗ Văn E", 1500, 500);
        CheckingAccount ca3 = new CheckingAccount("CA003", "Hoàng Thị F", 2000, 800);

        // Thêm vào ngân hàng
        bank.addAccount(sa1);
        bank.addAccount(sa2);
        bank.addAccount(sa3);
        bank.addAccount(ca1);
        bank.addAccount(ca2);
        bank.addAccount(ca3);

        bank.deposit("SA001", 1000);
        bank.withdraw("CA001", 500);
        bank.withdraw("CA002", 600); // vượt hạn mức, thất bại
        bank.deposit("SA003", 2000);
        bank.withdraw("CA003", 700);

        bank.applyInterestToAll();

        System.out.println("Tổng số dư trong ngân hàng: " + bank.getTotalBalance());

        bank.printTransactionLog();
    }

    public Bank getBank() {
        return bank;
    }
}
