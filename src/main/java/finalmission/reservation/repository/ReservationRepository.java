package finalmission.reservation.repository;

import finalmission.concert.domain.Concert;
import finalmission.reservation.domain.Reservation;
import finalmission.seat.domain.Seat;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository {

    Reservation save(Reservation reservation);

    Optional<Reservation> findById(Long id);

    List<Reservation> findAll();

    boolean existsByConcertAndSeat(Concert concert, Seat seat);
}
