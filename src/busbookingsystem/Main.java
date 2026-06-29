package busbookingsystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BusTicketBookingSystem system = new BusTicketBookingSystem();

        int choice;

        do {

            System.out.println("\n===== BUS TICKET BOOKING SYSTEM =====");
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. View Buses");
            System.out.println("4. Book Ticket");
            System.out.println("5. View Tickets");
            System.out.println("6. Cancel Ticket");
            System.out.println("7. Logout");
            System.out.println("8. Exit");

            System.out.print("Enter your Choice : ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    system.signUp();
                    break;

                case 2:
                    system.login();
                    break;

                case 3:
                    system.showBuses();
                    break;

                case 4:
                    system.bookTicket();
                    break;

                case 5:
                    system.viewTickets();
                    break;

                case 6:
                    system.cancelTicket();
                    break;

                case 7:
                    system.logout();
                    break;

                case 8:
                    System.out.println("Thank You...");
                    break;

                default:
                    System.out.println("Invalid Choice...");
            }

        } while (choice != 8);

        sc.close();
    }
}

