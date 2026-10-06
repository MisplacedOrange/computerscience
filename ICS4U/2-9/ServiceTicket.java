/*
Author: Roy Lu
Date: October 6th, 2026
Description: Stores information about a service ticket.
*/

public class ServiceTicket {
    private int ticketNumber;
    private String customerName;
    private String issueDescription;
    private boolean resolved;

    public ServiceTicket(int ticketNumber, String customerName, String issueDescription, boolean resolved) {
        this.ticketNumber = ticketNumber;
        this.customerName = customerName;
        this.issueDescription = issueDescription;
        this.resolved = resolved;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public boolean isResolved() {
        return resolved;
    }
}
