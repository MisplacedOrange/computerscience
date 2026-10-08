/*
Author: Roy Lu
Date: October 8th, 2026
Description: Tracks a savings balance and calculates monthly interest using a shared annual rate.
*/

public class SavingsAccount {
    private static double annualInterestRate = 0.0;
    private double savingsBalance;

    public SavingsAccount(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void calculateMonthlyInterest() {
        double monthlyInterest = savingsBalance * annualInterestRate / 12;
        savingsBalance += monthlyInterest;
    }

    // Use a decimal rate, such as 0.04 for 4%.
    public static void modifyInterestRate(double annualInterestRate) {
        SavingsAccount.annualInterestRate = annualInterestRate;
    }
}
