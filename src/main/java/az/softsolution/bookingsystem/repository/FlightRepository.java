package az.softsolution.bookingsystem.repository;

import az.softsolution.bookingsystem.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {

    List<Flight> findAllByDateIsGreaterThan(LocalDate date);

    List<Flight> findAllByDestinationEqualsAndDateEqualsAndFreeSeatsGreaterThanEqual(String destination,
                                                                                     LocalDate date, int count);
}
