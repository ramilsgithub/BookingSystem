package az.softsolution.bookingsystem.controller;

import az.softsolution.bookingsystem.dto.FlightDto;
import az.softsolution.bookingsystem.model.Flight;
import az.softsolution.bookingsystem.service.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class FlightControllerTest {

    @Mock
    FlightService service;

    @InjectMocks
    FlightController flightController;


    FlightDto flightDto;


    @BeforeEach
    void setUp() {

        LocalDate date = LocalDate.now();
        LocalDate nexdDay = LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth() + 1);

        FlightDto flightDto = FlightDto.builder()
                .id(1L)
                .date(nexdDay)
                .destination("Baku")
                .seats(66)
                .build();
    }

    @Test
    void getNextDay() {
        when(service.getNextDay()).thenReturn(Stream.of(flightDto).collect(Collectors.toList()));
        assertEquals(1, flightController.getNextDay().size());
        verify(service,times(1)).getNextDay();
    }

    @Test
    void getByID() {
        when(service.getById(1L)).thenReturn(flightDto);
        assertEquals("Baku", flightController.getByID(1L));
        verify(service,times(1)).getById(1L);
    }

}