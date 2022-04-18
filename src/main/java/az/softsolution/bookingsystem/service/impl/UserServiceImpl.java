package az.softsolution.bookingsystem.service.impl;

import az.softsolution.bookingsystem.dto.UserDto;
import az.softsolution.bookingsystem.dto.BookResponseDto;
import az.softsolution.bookingsystem.repository.UserRepository;
import az.softsolution.bookingsystem.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<BookResponseDto> showBooks(UserDto userDto) {
        return repository.findBooks(userDto.getName(),userDto.getSurname());
    }
}
