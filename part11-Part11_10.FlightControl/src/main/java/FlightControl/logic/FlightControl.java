package FlightControl.logic;

import FlightControl.domain.Airplane;
import FlightControl.domain.Flight;
import FlightControl.domain.Place;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Matt
 */
public class FlightControl {
    
    private HashMap<String, Airplane> airplanes;
    private HashMap<String, Flight> flights;
    private HashMap<String, Place> places;
   
    public FlightControl() {
        airplanes = new HashMap<>();
        flights = new HashMap<>();
        places = new HashMap<>();
    }
    
    public void addAirplane(String ID, int capacity) {
        airplanes.put(ID, new Airplane(ID, capacity));
    }
    
    public void addFlight(Airplane airplane, String departureID, String destinationID) {
        places.putIfAbsent(departureID, new Place(departureID));
        places.putIfAbsent(destinationID, new Place(destinationID));
        
        Flight flight = new Flight(airplane, places.get(departureID), places.get(destinationID));
        flights.put(flight.toString(), flight);
    }
    
    public List<Airplane> getAirplanes() {
        return airplanes.values().stream().collect(Collectors.toList());
    }
    
    public List<Flight> getFlights() {
        return flights.values().stream().collect(Collectors.toList());
    }
    
    public Airplane getAirplane(String ID) {
        return airplanes.getOrDefault(ID, null);
    }
}
