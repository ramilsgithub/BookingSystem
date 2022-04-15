package az.softsolution.bookingsystem.repository;

import az.softsolution.bookingsystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    @Query(value = "insert into booking.book(flight_id, user_id) values (?1, ?2)", nativeQuery = true)
    void book(Long flightId,Long userId);
}
