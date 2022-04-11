package az.softsolution.bookingsystem.controller;

import az.softsolution.bookingsystem.dto.UserDto;
import az.softsolution.bookingsystem.service.BookService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }


    @PostMapping("/{flightId}")
    public String book(@PathVariable(value = "flightId") Long flightId, @RequestBody UserDto userDto){
        Long id = service.book(flightId, userDto);
        return "Your book id is + " + id;
    }

    @DeleteMapping("/cancel/{id}")
    public String cancelBook(@PathVariable(value = "id") Long bookId){
        service.cancelBook(bookId);
        return "Deleted book id - " + bookId;
    }

}
