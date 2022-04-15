package az.softsolution.bookingsystem.service.impl;

import az.softsolution.bookingsystem.model.Book;
import az.softsolution.bookingsystem.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {

    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookServiceImpl service;

    @Test
    void cancelBook() {
        Book book = new Book();
        book.setId(1L);

        service.cancelBook(1L);
        verify(bookRepository, times(1)).delete(book);
    }
}