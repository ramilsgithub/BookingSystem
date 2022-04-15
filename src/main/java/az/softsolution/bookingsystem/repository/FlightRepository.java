package az.softsolution.bookingsystem.repository;

import az.softsolution.bookingsystem.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {

    List<Flight> findAllByDateEquals(LocalDate date);

    List<Flight> findAllByDestinationEqualsAndDateEqualsAndFreeSeatsGreaterThanEqual(String destination,
                                                                                     LocalDate date, int count);

    @Query(value = "update flight set free_seats = free_seats - ?1 where id = ?2",nativeQuery = true)
    void update(int n, Long flightId);
}
