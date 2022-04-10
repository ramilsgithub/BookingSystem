package az.softsolution.bookingsystem.mapper;

import az.softsolution.bookingsystem.dto.FlightDto;
import az.softsolution.bookingsystem.model.Flight;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FlightMapper {
    FlightDto toFlightDto(Flight flight);
    List<FlightDto> toFlightDtos(List<Flight> flights);
    Flight toFlight(FlightDto flightDto);
}
