package az.softsolution.bookingsystem.service;

import az.softsolution.bookingsystem.dto.UserDto;
import az.softsolution.bookingsystem.dto.BookResponseDto;

import java.util.List;

public interface UserService {
    List<BookResponseDto> showBooks(UserDto userDto);
}
