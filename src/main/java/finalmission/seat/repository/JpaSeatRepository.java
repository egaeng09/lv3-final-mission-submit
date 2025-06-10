package finalmission.seat.repository;

import finalmission.seat.domain.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSeatRepository extends JpaRepository<Seat, Long>, SeatRepository {

}
