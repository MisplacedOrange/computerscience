/*
Author: Roy Lu
Date: October 6th, 2026
Description: Demonstrates creating a service ticket.
*/

public class ServiceTicketTest {
    public static void main(String[] args) {
        ServiceTicket ticket = new ServiceTicket(
                1001,
                "Roy Lu",
                "Replace a damaged screen",
                false
        );

        System.out.println("Ticket number: " + ticket.getTicketNumber());
        System.out.println("Customer: " + ticket.getCustomerName());
        System.out.println("Issue: " + ticket.getIssueDescription());
        System.out.println("Resolved: " + ticket.isResolved());
    }
}
