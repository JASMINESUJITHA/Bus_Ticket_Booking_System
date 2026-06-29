package busbookingsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class BusTicketBookingSystem {

    ArrayList<Customer> customers = new ArrayList<>();
    ArrayList<Bus> buses = new ArrayList<>();
    ArrayList<Ticket> tickets = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    int customerId = 1;
    int ticketId = 1;

    Customer currentCustomer = null;

    public BusTicketBookingSystem() {

        buses.add(new Bus(101, "KPN Travels", "AC Sleeper",
                "Chennai", "Coimbatore", 40, 850));

        buses.add(new Bus(102, "SRS Travels", "Non AC Seater",
                "Chennai", "Madurai", 45, 600));

        buses.add(new Bus(103, "Parveen Travels", "AC Seater",
                "Chennai", "Trichy", 35, 700));
    }

    public void signUp() {

        System.out.println("\n----- SIGN UP -----");

        System.out.print("Enter Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Password : ");
        String password = sc.nextLine();

        System.out.print("Enter Age : ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Gender : ");
        String gender = sc.nextLine();

        Customer customer = new Customer(customerId++, name,
                password, age, gender);

        customers.add(customer);

        System.out.println("Registration Successful...");
    }

    public boolean login() {

        System.out.println("\n----- LOGIN -----");

        System.out.print("Enter Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Password : ");
        String password = sc.nextLine();

        for (Customer c : customers) {

            if (c.getName().equals(name)
                    && c.getPassword().equals(password)) {

                currentCustomer = c;

                System.out.println("Login Successful...");
                return true;
            }
        }

        System.out.println("Invalid Login...");
        return false;
    }

    public void showBuses() {

        System.out.println("\n------ AVAILABLE BUSES ------");

        for (Bus bus : buses) {

            System.out.println(bus);
            System.out.println("--------------------------");
        }
    }

    public void bookTicket() {

        if (currentCustomer == null) {

            System.out.println("Please Login First...");
            return;
        }

        showBuses();

        System.out.print("Enter Bus ID : ");
        int id = sc.nextInt();

        System.out.print("Enter Number of Seats : ");
        int seats = sc.nextInt();

        for (Bus bus : buses) {

            if (bus.getBusId() == id) {

                if (bus.getAvailableSeats() >= seats) {

                    bus.bookSeat(seats);

                    double totalFare = seats * bus.getFare();

                    Ticket ticket = new Ticket(ticketId++,
                            currentCustomer,
                            bus,
                            seats,
                            totalFare);

                    tickets.add(ticket);

                    System.out.println("\nBooking Successful...");
                    System.out.println(ticket);

                } else {

                    System.out.println("Seats Not Available...");
                }

                return;
            }
        }

        System.out.println("Invalid Bus ID...");
    }

    public void viewTickets() {

        if (currentCustomer == null) {
            System.out.println("Please Login First...");
            return;
        }

        boolean found = false;

        for (Ticket ticket : tickets) {

            if (ticket.getCustomer().getCustomerId() == currentCustomer.getCustomerId()) {
                System.out.println(ticket);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Tickets Booked...");
        }
    }

    public void cancelTicket() {

        if (currentCustomer == null) {
            System.out.println("Please Login First...");
            return;
        }

        System.out.print("Enter Ticket ID to Cancel : ");
        int id = sc.nextInt();

        for (int i = 0; i < tickets.size(); i++) {

            Ticket ticket = tickets.get(i);

            if (ticket.getTicketId() == id &&
                    ticket.getCustomer().getCustomerId() == currentCustomer.getCustomerId()) {

                ticket.getBus().cancelSeat(ticket.getNumberOfSeats());

                tickets.remove(i);

                System.out.println("Ticket Cancelled Successfully...");
                return;
            }
        }

        System.out.println("Ticket Not Found...");
    }

    public void logout() {

        currentCustomer = null;
        System.out.println("Logged Out Successfully...");
    }
}


