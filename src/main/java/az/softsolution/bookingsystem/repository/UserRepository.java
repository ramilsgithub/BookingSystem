package az.softsolution.bookingsystem.repository;

import az.softsolution.bookingsystem.model.Book;
import az.softsolution.bookingsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select id, flight_id, user.name, user.surname from book inner join user on book.user_id = user.id",
            nativeQuery = true)
    List<Book> findBooks(String name, String surname);
}
