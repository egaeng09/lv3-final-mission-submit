package finalmission.seat.service.detail;

import finalmission.seat.domain.Seat;
import finalmission.seat.repository.SeatRepository;
import finalmission.venue.domain.Venue;
import finalmission.venue.repository.VenueRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SeatQueryService {

    private final SeatRepository seatRepository;

    public Seat get(Long id) {
        return seatRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID에 해당하는 좌석을 찾을 수 없습니다."));
    }

    public List<Seat> getAll() {
        return seatRepository.findAll();
    }
}
