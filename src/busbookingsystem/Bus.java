package busbookingsystem;

public class Bus {

    private int busId;
    private String busName;
    private String busType;
    private String source;
    private String destination;
    private int totalSeats;
    private int availableSeats;
    private double fare;

    public Bus(int busId, String busName, String busType,
               String source, String destination,
               int totalSeats, double fare) {

        this.busId = busId;
        this.busName = busName;
        this.busType = busType;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.fare = fare;
    }

    public int getBusId() {
        return busId;
    }

    public String getBusName() {
        return busName;
    }

    public String getBusType() {
        return busType;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public double getFare() {
        return fare;
    }

    public void bookSeat(int seats) {
        if (availableSeats >= seats) {
            availableSeats -= seats;
        }
    }

    public void cancelSeat(int seats) {
        availableSeats += seats;

        if (availableSeats > totalSeats) {
            availableSeats = totalSeats;
        }
    }

    @Override
    public String toString() {
        return "Bus ID : " + busId +
                "\nBus Name : " + busName +
                "\nBus Type : " + busType +
                "\nFrom : " + source +
                "\nTo : " + destination +
                "\nTotal Seats : " + totalSeats +
                "\nAvailable Seats : " + availableSeats +
                "\nFare : ₹" + fare;
    }
}

