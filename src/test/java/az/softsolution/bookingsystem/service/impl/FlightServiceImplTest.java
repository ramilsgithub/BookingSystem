package az.softsolution.bookingsystem.service.impl;

import az.softsolution.bookingsystem.dto.FlightDto;
import az.softsolution.bookingsystem.mapper.FlightMapper;
import az.softsolution.bookingsystem.model.Flight;
import az.softsolution.bookingsystem.repository.FlightRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FlightServiceImplTest {

    @Mock
    FlightRepository flightRepository;

    @Mock
     FlightMapper mapper;

    @InjectMocks
    FlightServiceImpl service;


    Flight flight;
    FlightDto flightDto;

    LocalDate date = LocalDate.now();
    LocalDate nexdDay = LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth() + 1);


    @BeforeEach
    void setUp() {
        flight = Flight.builder().
                id(1L).
                date(nexdDay).
                destination("Baku").
                seats(66).
                build();

        flightDto = FlightDto.builder()
                .id(1L)
                .date(nexdDay)
                .destination("Baku")
                .seats(66)
                .build();
    }


    @Test
    void getNextDayTest() {
        when(flightRepository.findAllByDateEquals(nexdDay)).thenReturn(Stream.of(flight).collect(Collectors.toList()));
        when(mapper.toFlightDtos(Stream.of(flight).collect(Collectors.toList()))).
                thenReturn(Stream.of(flightDto).collect(Collectors.toList()));
        assertEquals(1, service.getNextDay().size());
        verify(flightRepository,times(1)).findAllByDateEquals(nexdDay);
    }

    @Test
    void getByIdTest() {

        when(flightRepository.findById(1L)).thenReturn(Optional.of(flight));

        when(mapper.toFlightDto(flight)).thenReturn(flightDto);

        assertEquals("Baku", service.getById(1L).getDestination());

        verify(flightRepository,times(1)).findById(1L);

    }


    @Test
    void searchTest() {

        when(flightRepository.findAllByDestinationEqualsAndDateEqualsAndFreeSeatsGreaterThanEqual("Baku", nexdDay,2)).
                thenReturn(Stream.of(flight).collect(Collectors.toList()));

        when(mapper.toFlightDtos(Stream.of(flight).collect(Collectors.toList()))).
                thenReturn(Stream.of(flightDto).collect(Collectors.toList()));

        assertEquals(1, service.search("Baku", nexdDay,2).size());

        verify(flightRepository,times(1)).
                findAllByDestinationEqualsAndDateEqualsAndFreeSeatsGreaterThanEqual("Baku", nexdDay,2);

    }


}