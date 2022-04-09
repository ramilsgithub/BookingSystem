package az.softsolution.bookingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
public class FlightDto {

    private Long id;
    private LocalDate date;
    private LocalTime time;
    private String destination;
    private int seats;
    private int freeSeats;
}
