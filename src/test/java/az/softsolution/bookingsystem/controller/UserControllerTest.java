package az.softsolution.bookingsystem.controller;

import az.softsolution.bookingsystem.dto.BookResponseDto;
import az.softsolution.bookingsystem.dto.UserDto;
import az.softsolution.bookingsystem.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    UserService service;

    @InjectMocks
    UserController controller;

    @Test
    void showBooks() {
        BookResponseDto bookResponseDto = BookResponseDto.builder()
                .bookId(1L)
                .flightId(1L)
                .name("name")
                .surname("surname")
                .build();

        UserDto userDto = UserDto.builder()
                .name("name")
                .surname("surname")
                .build();

        when(service.showBooks(userDto)).thenReturn(Stream.of(bookResponseDto).collect(Collectors.toList()));
        assertEquals(1,controller.showBooks(userDto).size());
        verify(service,times(1)).showBooks(userDto);

    }
}