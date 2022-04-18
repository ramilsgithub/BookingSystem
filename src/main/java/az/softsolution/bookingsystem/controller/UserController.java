package az.softsolution.bookingsystem.controller;

import az.softsolution.bookingsystem.dto.UserDto;
import az.softsolution.bookingsystem.dto.BookResponseDto;
import az.softsolution.bookingsystem.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("show")
    public List<BookResponseDto> showBooks(@RequestBody UserDto userDto){
       return service.showBooks(userDto);
    }
}
