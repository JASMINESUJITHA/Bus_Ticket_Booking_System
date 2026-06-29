package busbookingsystem;

public class Ticket {

    private int ticketId;
    private Customer customer;
    private Bus bus;
    private int numberOfSeats;
    private double totalFare;

    public Ticket(int ticketId, Customer customer, Bus bus,
                  int numberOfSeats, double totalFare) {

        this.ticketId = ticketId;
        this.customer = customer;
        this.bus = bus;
        this.numberOfSeats = numberOfSeats;
        this.totalFare = totalFare;
    }

    public int getTicketId() {
        return ticketId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Bus getBus() {
        return bus;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public double getTotalFare() {
        return totalFare;
    }

    @Override
    public String toString() {
        return "\n========== TICKET ==========" +
                "\nTicket ID      : " + ticketId +
                "\nCustomer Name  : " + customer.getName() +
                "\nBus Name       : " + bus.getBusName() +
                "\nFrom           : " + bus.getSource() +
                "\nTo             : " + bus.getDestination() +
                "\nSeats Booked   : " + numberOfSeats +
                "\nTotal Fare     : ₹" + totalFare +
                "\n============================";
    }
}
