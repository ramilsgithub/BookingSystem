package az.softsolution.bookingsystem.service.impl;

import az.softsolution.bookingsystem.dto.UserDto;
import az.softsolution.bookingsystem.exception.BookNotFoundException;
import az.softsolution.bookingsystem.mapper.UserMapper;
import az.softsolution.bookingsystem.model.Book;
import az.softsolution.bookingsystem.model.User;
import az.softsolution.bookingsystem.repository.BookRepository;
import az.softsolution.bookingsystem.repository.UserRepository;
import az.softsolution.bookingsystem.service.BookService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public BookServiceImpl(BookRepository repository, UserRepository userRepository, UserMapper userMapper) {
        this.bookRepository = repository;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Long book(Long flightId, UserDto userDto) {
        User user = userMapper.toUser(userDto);
        User savedUser = userRepository.save(user);
        Long addedUserId = savedUser.getId();
        Book book = bookRepository.book(flightId, addedUserId);
        return book.getId();
    }

    @Override
    public Long cancelBook(Long bookId) {

        Optional<Book> book = bookRepository.findById(bookId);

        if (book.isPresent()) {
            Book book1 = book.get();
            bookRepository.delete(book1);
            return bookId;
        }else {
            throw new BookNotFoundException("Not found" + bookId);
        }
    }
}
