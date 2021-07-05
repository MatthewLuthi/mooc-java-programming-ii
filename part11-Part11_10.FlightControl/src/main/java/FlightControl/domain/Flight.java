package FlightControl.domain;

/**
 *
 * @author Matt
 */
public class Flight {
    
    private Airplane airplane;
    private Place departure, destination;
    
    public Flight(Airplane airplane, Place departure, Place destination) {
        this.airplane = airplane;
        this.departure = departure;
        this.destination = destination;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public Place getDeparture() {
        return departure;
    }

    public Place getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return airplane.toString() + " (" + departure + "-" + destination + ")";
    }
}
