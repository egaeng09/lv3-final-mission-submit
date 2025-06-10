package finalmission.seat.repository;

import finalmission.seat.domain.Seat;
import java.util.List;
import java.util.Optional;

public interface SeatRepository {

    Seat save(Seat seat);

    Optional<Seat> findById(Long id);

    List<Seat> findAll();
}
