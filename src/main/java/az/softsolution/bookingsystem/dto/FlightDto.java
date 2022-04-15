package az.softsolution.bookingsystem.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlightDto {

    private Long id;
    private LocalDate date;
    private LocalTime time;
    private String destination;
    private int seats;
    private int freeSeats;
}
