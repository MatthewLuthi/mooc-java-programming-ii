package FlightControl.ui;

import FlightControl.domain.Airplane;
import FlightControl.logic.FlightControl;
import java.util.Scanner;

/**
 *
 * @author Matt
 */
public class UserInterface {

    private FlightControl flightControl;
    private Scanner scanner;

    public UserInterface() {
        this.flightControl = new FlightControl();
        this.scanner = new Scanner(System.in);
    }

    public void start() {

        startAssetControl();
        System.out.println();
        startFlightControl();
        System.out.println();
    }

    private void startAssetControl() {
        System.out.println("Airport Asset Control");
        System.out.println("--------------------\n");

        while (true) {
            printAssetActions();
            System.out.print(">");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("x")) {
                break;
            } else if (answer.equals("1")) {
                addAirplane();
            } else if (answer.equals("2")) {
                addFlight();
            }
        }
    }

    private void printAssetActions() {
        System.out.print("Choose an action:\n"
                + "[1] Add an airplane\n"
                + "[2] Add a flight\n"
                + "[x] Exit Airport Asset Control\n");
    }

    private void addAirplane() {
        System.out.print("Give the airplane id: ");
        String id = scanner.nextLine();
        System.out.print("Give the airplane capacity: ");
        int capacity = Integer.valueOf(scanner.nextLine());

        flightControl.addAirplane(id, capacity);
    }

    private void addFlight() {
        System.out.print("Give the airplane id: ");
        Airplane plane = askForAirplane();
        System.out.print("Give the departure airport id: ");
        String departureID = scanner.nextLine();
        System.out.print("Give the target airport id: ");
        String destinationID = scanner.nextLine();

        flightControl.addFlight(plane, departureID, destinationID);
    }

    private void startFlightControl() {
        System.out.println("Flight Control");
        System.out.println("------------\n");
        
        while (true) {
            printFlightActions();
            System.out.print(">");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("x")) {
                break;
            } else if (answer.equals("1")) {
                printAirplanes();
            } else if (answer.equals("2")) {
                printFlights();
            } else {
                printAirplaneDetails();
            }
        }
    }

    private void printFlightActions() {
        System.out.println("Choose an action:\n"
                + "[1] Print airplanes\n"
                + "[2] Print flights\n"
                + "[3] Print airplane details\n"
                + "[x] Quit\n");
    }

    private void printAirplanes() {
        flightControl.getAirplanes().stream().forEach(airplane -> System.out.println(airplane));
    }

    private void printFlights() {
        flightControl.getFlights().stream().forEach(flight -> System.out.println(flight));
    }

    private void printAirplaneDetails() {
        System.out.print("Give the airplane id: ");
        Airplane plane = askForAirplane();
        System.out.println(plane);
    }

    private Airplane askForAirplane() {
        Airplane plane = null;
        while (null == plane) {
            String id = scanner.nextLine();
            plane = flightControl.getAirplane(id);

            if (null == plane) {
                System.out.println("No airplane with id " + id + ".");
            }
        }

        return plane;
    }
}
