package az.softsolution.bookingsystem.repository;

import az.softsolution.bookingsystem.model.Book;
import az.softsolution.bookingsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select b.id, b.flight_id, u.name, u.surname from booking.book b inner join booking.user u on b.user_id = u.id " +
            "where u.name = :name and u.surname = :surname",
            nativeQuery = true)
    List<Object[]> findBooks(@Param(value = "name") String name,@Param(value = "surname") String surname);
}
