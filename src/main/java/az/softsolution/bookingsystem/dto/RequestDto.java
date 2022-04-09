package az.softsolution.bookingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
public class RequestDto {
    private String destination;
    private LocalDate date;
    private int numberOfPeople;
}
