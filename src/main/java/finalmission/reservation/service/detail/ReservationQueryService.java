package finalmission.reservation.service.detail;

import finalmission.common.exception.NotFoundException;
import finalmission.concert.domain.Concert;
import finalmission.reservation.domain.Reservation;
import finalmission.reservation.repository.ReservationRepository;
import finalmission.seat.domain.Seat;
import java.util.Collection;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReservationQueryService {

    private final ReservationRepository reservationRepository;

    public Reservation get(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID에 해당하는 예약을 찾을 수 없습니다."));
    }

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    public boolean existsByConcertAndSeat(final Concert concert, final Seat seat) {
        return reservationRepository.existsByConcertAndSeat(concert, seat);
    }

    public List<Reservation> getByMemberId(final Long memberId) {
        return reservationRepository.findByMemberId(memberId);
    }
}
