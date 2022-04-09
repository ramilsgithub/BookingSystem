package az.softsolution.bookingsystem.service.impl;

import az.softsolution.bookingsystem.dto.UserDto;
import az.softsolution.bookingsystem.model.Book;
import az.softsolution.bookingsystem.repository.UserRepository;
import az.softsolution.bookingsystem.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Book> showBooks(UserDto userDto) {
        return repository.findBooks(userDto.getName(),userDto.getSurname());
    }
}
