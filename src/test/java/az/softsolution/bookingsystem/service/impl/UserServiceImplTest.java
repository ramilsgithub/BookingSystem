package az.softsolution.bookingsystem.service.impl;

import az.softsolution.bookingsystem.dto.BookResponseDto;
import az.softsolution.bookingsystem.dto.UserDto;
import az.softsolution.bookingsystem.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl service;

    @Test
    void showBooks() {
        UserDto userDto = new UserDto();
        BookResponseDto bookResponseDto = new BookResponseDto();

        when(userRepository.findBooks(userDto)).thenReturn(Stream.of(bookResponseDto).collect(Collectors.toList()));
        assertEquals(1, service.showBooks(userDto).size());
    }
}