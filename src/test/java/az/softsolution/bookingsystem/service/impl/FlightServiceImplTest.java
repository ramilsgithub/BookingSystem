package az.softsolution.bookingsystem.service.impl;

import az.softsolution.bookingsystem.dto.FlightDto;
import az.softsolution.bookingsystem.mapper.FlightMapper;
import az.softsolution.bookingsystem.model.Flight;
import az.softsolution.bookingsystem.repository.FlightRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FlightServiceImplTest {

    @Mock
    private FlightRepository repository;

    @Mock
    private FlightMapper mapper;

    @InjectMocks
    private FlightServiceImpl service;


    @Test
    void getNextDay() {
        LocalDate date = LocalDate.now();
        LocalDate nexdDay = LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth() + 1);
        Flight flight = new Flight().builder().
                date(nexdDay).
                destination("Baku").
                seats(66).
                build();

        when(repository.findAllByDateEquals(nexdDay)).thenReturn(Stream.of(flight).collect(Collectors.toList()));

        assertEquals(1, service.getNextDay().size());
        verify(repository,times(1)).findAllByDateEquals(nexdDay);
    }

    @Test
    void getById() {
            Flight flight = new Flight().builder().
                    id(1L).
                    destination("Ganja").
                    build();
            when(repository.findById(1L)).thenReturn(Optional.of(flight));
            FlightDto flightDto = service.getById(1l);
            assertEquals("Ganja", flightDto.getDestination());
    }


}