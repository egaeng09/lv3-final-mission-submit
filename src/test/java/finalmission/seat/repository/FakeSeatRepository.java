package finalmission.seat.repository;

import finalmission.seat.domain.Seat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

class FakeSeatRepository implements SeatRepository {

    List<Seat> seats = new ArrayList<>();
    AtomicLong atomicLong = new AtomicLong(1L);


    @Override
    public Seat save(final Seat seat) {
        final Seat saved = new Seat(atomicLong.getAndIncrement(), seat.getSeatNumber(), seat.getVenue());
        seats.add(saved);
        return saved;
    }

    @Override
    public Optional<Seat> findById(final Long id) {
        return seats.stream()
                .filter(seat -> seat.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Seat> findAll() {
        return new ArrayList<>(seats);
    }
}
