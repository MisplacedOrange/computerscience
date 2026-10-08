/*
Author: Roy Lu
Date: October 8th, 2026
Description: Demonstrates monthly interest calculations for two savings accounts.
*/

public class SavingsAccountTest {
    public static void main(String[] args) {
        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);

        SavingsAccount.modifyInterestRate(0.04);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.println("After the first month at 4% annual interest:");
        System.out.printf("Saver 1 balance: $%.2f%n", saver1.getSavingsBalance());
        System.out.printf("Saver 2 balance: $%.2f%n", saver2.getSavingsBalance());

        SavingsAccount.modifyInterestRate(0.05);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.println("After the second month at 5% annual interest:");
        System.out.printf("Saver 1 balance: $%.2f%n", saver1.getSavingsBalance());
        System.out.printf("Saver 2 balance: $%.2f%n", saver2.getSavingsBalance());
    }
}
