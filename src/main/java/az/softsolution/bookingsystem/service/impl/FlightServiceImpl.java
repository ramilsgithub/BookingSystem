package az.softsolution.bookingsystem.service.impl;

import az.softsolution.bookingsystem.dto.FlightDto;
import az.softsolution.bookingsystem.exception.FlightNotFoundException;
import az.softsolution.bookingsystem.mapper.FlightMapper;
import az.softsolution.bookingsystem.model.Flight;
import az.softsolution.bookingsystem.repository.FlightRepository;
import az.softsolution.bookingsystem.service.FlightService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository repository;
    private final FlightMapper mapper;

    public FlightServiceImpl(FlightRepository repository, FlightMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public List<FlightDto> getNextDay() {
        LocalDate date = LocalDate.now();
        LocalDate nexdDay = LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth() + 1);
        List<Flight> flights = repository.findAllByDateEquals(nexdDay);
        List<FlightDto> flightDtos = mapper.toFlightDtos(flights);
        return flightDtos;
    }

    @Override
    public FlightDto getById(long id) {
        Optional<Flight> flight = repository.findById(id);
        if (flight.isPresent()) {
            FlightDto flightDto = mapper.toFlightDto(flight.get());
            return flightDto;
        } else {
            throw new FlightNotFoundException("Flight id not found - " + id);
        }
    }

    @Override
    public List<FlightDto> search(String destination, LocalDate date, int numberOfPeople) {
        List<Flight> flights = repository.findAllByDestinationEqualsAndDateEqualsAndFreeSeatsGreaterThanEqual(destination,
                date, numberOfPeople);
        List<FlightDto> flightDtos = mapper.toFlightDtos(flights);
        return flightDtos;
    }
}
