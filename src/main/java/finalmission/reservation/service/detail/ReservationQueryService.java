package finalmission.reservation.service.detail;

import finalmission.reservation.domain.Reservation;
import finalmission.reservation.repository.ReservationRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReservationQueryService {

    private final ReservationRepository reservationRepository;

    public Reservation get(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID에 해당하는 예약을 찾을 수 없습니다."));
    }

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }
}
