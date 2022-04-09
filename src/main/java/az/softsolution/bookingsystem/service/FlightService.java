package az.softsolution.bookingsystem.service;

import az.softsolution.bookingsystem.dto.FlightDto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface FlightService {
    List<FlightDto> getNextDay();
    FlightDto getById(long id);
    List<FlightDto> search(String destination, LocalDate dateate, int numberOfPeople);
}
