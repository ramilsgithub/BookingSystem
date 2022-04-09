package az.softsolution.bookingsystem.service;

import az.softsolution.bookingsystem.dto.UserDto;
import az.softsolution.bookingsystem.model.Book;

import java.util.List;

public interface UserService {
    List<Book> showBooks(UserDto userDto);
}
