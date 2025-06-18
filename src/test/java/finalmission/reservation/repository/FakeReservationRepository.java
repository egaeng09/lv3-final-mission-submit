package finalmission.reservation.repository;

import finalmission.concert.domain.Concert;
import finalmission.reservation.domain.Reservation;
import finalmission.seat.domain.Seat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class FakeReservationRepository implements ReservationRepository {

    List<Reservation> reservations = new ArrayList<>();
    AtomicLong atomicLong = new AtomicLong(1L);


    @Override
    public Reservation save(final Reservation reservation) {
        final Reservation saved = new Reservation(atomicLong.getAndIncrement(), reservation.getMember(), reservation.getConcert(), reservation.getSeat());
        reservations.add(saved);
        return saved;
    }

    @Override
    public Optional<Reservation> findById(final Long id) {
        return reservations.stream()
                .filter(reservation -> reservation.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Reservation> findAll() {
        return new ArrayList<>(reservations);
    }

    @Override
    public List<Reservation> findByMemberId(final Long memberId) {
        return reservations.stream()
                .filter(reservation -> reservation.getMember().getId().equals(memberId))
                .toList();
    }

    @Override
    public boolean existsByConcertAndSeat(final Concert concert, final Seat seat) {
        return reservations.stream()
                .anyMatch(reservation -> reservation.getConcert().equals(concert) && reservation.getSeat().equals(seat));
    }
}
