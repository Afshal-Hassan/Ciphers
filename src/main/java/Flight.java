public class Flight {

    private Integer flightNumber;
    private String source;
    private String destination;
    private Integer noOfSeats;

    public Flight(Integer flightNumber, String source, String destination, Integer noOfSeats) {
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.noOfSeats = noOfSeats;
    }

    public Flight(Integer flightNumber, Integer noOfSeats) {
        this.flightNumber = flightNumber;
        this.noOfSeats = noOfSeats;
    }

    public Flight(Integer flightNumber ) {
        this.flightNumber = flightNumber;
    }

    public void reserveSeats(Integer noOfSeats) {
        if(noOfSeats <= this.noOfSeats ) {
            System.out.println("Seats are reserved");
        } else {
            System.out.println("No of seats not available");
        }
    }

    public void cancelSeats(int noOfSeats) {
        this.noOfSeats = this.noOfSeats - noOfSeats;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber=" + flightNumber +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", noOfSeats=" + noOfSeats +
                '}';
    }

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public Integer getNoOfSeats() {
        return noOfSeats;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setNoOfSeats(Integer noOfSeats) {
        this.noOfSeats = noOfSeats;
    }
}
