package finalmission.reservation.service.detail;

import finalmission.reservation.domain.Reservation;
import finalmission.reservation.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReservationCommandService {

    private final ReservationRepository reservationRepository;

    public Reservation create(final Reservation reservation) {
        return reservationRepository.save(reservation);
    }
}
