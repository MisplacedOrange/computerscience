/*
Author: Roy Lu
Date: October 5th, 2026
Description: Stores item details and calculates an invoice.
*/

public class Q3 {
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            quantity = 0;
        }
        this.quantity = quantity;
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(double pricePerItem) {
        if (pricePerItem <= 0) {
            pricePerItem = 0.0;
        }
        this.pricePerItem = pricePerItem;
    }

    public double getInvoiceAmount() {
        return quantity * pricePerItem;
    }
}

class InvoiceTest {
    public static void main(String[] args) {
        Q3 invoice = new Q3();
        invoice.setPartNumber("H101");
        invoice.setPartDescription("Hammer");
        invoice.setQuantity(3);
        invoice.setPricePerItem(12.50);

        System.out.println("Part number: " + invoice.getPartNumber());
        System.out.println("Description: " + invoice.getPartDescription());
        System.out.println("Quantity: " + invoice.getQuantity());
        System.out.println("Price per item: $" + invoice.getPricePerItem());
        System.out.println("Invoice amount: $" + invoice.getInvoiceAmount());

        invoice.setQuantity(-3);
        System.out.println("After negative quantity: " + invoice.getQuantity());
        System.out.println("Invoice amount: $" + invoice.getInvoiceAmount());

        invoice.setQuantity(3);
        invoice.setPricePerItem(-12.50);
        System.out.println("After negative price: $" + invoice.getPricePerItem());
        System.out.println("Invoice amount: $" + invoice.getInvoiceAmount());

        invoice.setQuantity(0);
        invoice.setPricePerItem(0.0);
        System.out.println("After zero values: " + invoice.getQuantity() + ", $" + invoice.getPricePerItem());
        System.out.println("Invoice amount: $" + invoice.getInvoiceAmount());
    }
}
