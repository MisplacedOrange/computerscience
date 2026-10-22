/*
Author: Roy Lu
Date: October 22nd, 2026
Description: Stores sales entries in a two-dimensional array and prints salesperson, product, and overall totals.
*/

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] sales = new double[4][5];

        while (true) {
            System.out.print("Enter salesperson number 1-4, or -1 to finish: ");
            int salesperson = sc.nextInt();

            if (salesperson == -1) {
                break;
            }

            if (salesperson < 1 || salesperson > 4) {
                System.out.println("Invalid salesperson.");
                continue;
            }

            System.out.print("Enter product ID 105-109: ");
            int product = sc.nextInt();

            if (product < 105 || product > 109) {
                System.out.println("Invalid product ID.");
                continue;
            }

            System.out.print("Enter amount sold: ");
            double amount = sc.nextDouble();

            if (amount < 0) {
                System.out.println("Invalid amount.");
                continue;
            }

            sales[salesperson - 1][product - 105] += amount;

            System.out.printf("%-15s", "Salesperson");

            for (int i = 105; i <= 109; i++) {
                System.out.printf("%15d", i);
            }

            System.out.printf("%15s%n", "Total");

            double[] productTotals = new double[5];

            for (int i = 0; i < 4; i++) {
                double salespersonTotal = 0;

                System.out.printf("%-15d", i + 1);

                for (int j = 0; j < 5; j++) {
                    System.out.printf("%15s", String.format("$%,.2f", sales[i][j]));

                    salespersonTotal += sales[i][j];
                    productTotals[j] += sales[i][j];
                }

                System.out.printf("%15s%n", String.format("$%,.2f", salespersonTotal));
            }

            System.out.printf("%-15s", "Total");

            double grandTotal = 0;

            for (int j = 0; j < 5; j++) {
                System.out.printf("%15s", String.format("$%,.2f", productTotals[j]));
                grandTotal += productTotals[j];
            }

            System.out.printf("%15s%n", String.format("$%,.2f", grandTotal));
            System.out.println();
        }

        sc.close();
    }
}
