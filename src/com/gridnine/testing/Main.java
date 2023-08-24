package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        List<FlightFilter> filters = new ArrayList<>();
        filters.add(new DepartureBeforeCurrentTimeFilter());
        filters.add(new ArrivalBeforeDepartureFilter());
        filters.add(new TotalGroundTimeFilter());

        for (FlightFilter filter : filters) {
            List<Flight> filteredFlights = filter.filterFlights(flights);
            System.out.println("Flights after filtering:");
            filteredFlights.forEach(System.out::println);
            System.out.println("===================================");
        }
    }
}