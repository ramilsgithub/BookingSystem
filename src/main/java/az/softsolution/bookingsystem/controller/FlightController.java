package az.softsolution.bookingsystem.controller;

import az.softsolution.bookingsystem.dto.FlightDto;
import az.softsolution.bookingsystem.dto.RequestDto;
import az.softsolution.bookingsystem.service.FlightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    private final FlightService service;

    public FlightController(FlightService service) {
        this.service = service;
    }
    @GetMapping("/next_day")
    public List<FlightDto> getNextDay() {
        return service.getNextDay();
    }

    @GetMapping("/{id}")
    public FlightDto getByID(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/detailed_search")
    public List<FlightDto> serch(@RequestBody RequestDto requestDto){
        return service.search(requestDto.getDestination(),requestDto.getDate(),requestDto.getNumberOfPeople());
    }
}
