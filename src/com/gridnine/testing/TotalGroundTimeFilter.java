package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class TotalGroundTimeFilter implements FlightFilter {
    @Override
    public List<Flight> filterFlights(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> {
                    int totalGroundTime = 0;
                    for (int i = 0; i < flight.getSegments().size() - 1; i++) {
                        LocalDateTime arrival = flight.getSegments().get(i).getArrivalDate();
                        LocalDateTime nextDeparture = flight.getSegments().get(i + 1).getDepartureDate();
                        totalGroundTime += ChronoUnit.HOURS.between(arrival, nextDeparture);
                    }
                    return totalGroundTime <= 2;
                })
                .collect(Collectors.toList());
    }
}
