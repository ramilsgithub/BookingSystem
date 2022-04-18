package az.softsolution.bookingsystem.service.impl;

import az.softsolution.bookingsystem.mapper.UserMapper;
import az.softsolution.bookingsystem.model.Book;
import az.softsolution.bookingsystem.repository.BookRepository;
import az.softsolution.bookingsystem.repository.FlightRepository;
import az.softsolution.bookingsystem.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {

    @Mock
    UserRepository userRepository;
    @Mock
    FlightRepository flightRepository;
    @Mock
    UserMapper userMapper;
    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookServiceImpl service;

    @Test
    void cancelBook() {
        Book book = Book.builder()
                .id(1L)
                .build();
        Long n = 1L;
        book.setId(n);
        Book book1 = new Book();

        when(bookRepository.findById(n)).thenReturn(Optional.of(book1));


        when(bookRepository.delete(book)).thenReturn(n);
        service.cancelBook(1L);
        verify(bookRepository, times(1)).delete(book);
    }
}