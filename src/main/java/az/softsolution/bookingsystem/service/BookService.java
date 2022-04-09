package az.softsolution.bookingsystem.service;

import az.softsolution.bookingsystem.dto.UserDto;

public interface BookService {
    Long book(Long flightId, UserDto userDto);
    Long cancelBook(Long bookId);
}
