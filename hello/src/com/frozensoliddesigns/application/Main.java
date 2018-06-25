package com.frozensoliddesigns.application;

import com.frozensoliddesigns.flight.*;

public class Main {

    public static void main(String[] args) {
	    Flight f = new Flight();

	    Passenger p1 = new Passenger(0,1);
	    Passenger p2 = new Passenger(0, 2);
        Passenger p3 = new Passenger(0,1);
        Passenger p4 = new Passenger(0, 2);

	    f.addPassenger();
	    f.addPassenger(2);
	    f.addPassenger(p1);
	    f.addPassenger(p2, 1);
	    f.addPassengers(p3, p4);

	    System.out.println(f.getPassengers());
	    System.out.println(f.getSeats());

	    CargoFlight cf = new CargoFlight();
	    CargoFlight cf295 = new CargoFlight(295);
		CargoFlight cf300 = new CargoFlight(300, 2000.0f);

	    cf.addPackage(1.0f, 2.5f, 3.0f);

	    Passenger cp = new Passenger();
	    cf.addPassenger(cp);

	    System.out.println(cf.getPassengers());
        System.out.println(cf.getSeats());

        CrewMember judy = new CrewMember(FlightCrewJob.CoPilot);

        System.out.println(judy.getJob());
    }
}
