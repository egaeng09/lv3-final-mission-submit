package finalmission.reservation.service;

import finalmission.concert.domain.Concert;
import finalmission.concert.service.detail.ConcertQueryService;
import finalmission.member.domain.Member;
import finalmission.member.service.MemberQueryService;
import finalmission.reservation.controller.dto.ReservationRequest;
import finalmission.reservation.controller.dto.ReservationResponse;
import finalmission.reservation.domain.Reservation;
import finalmission.reservation.service.detail.ReservationCommandService;
import finalmission.reservation.service.detail.ReservationQueryService;
import finalmission.seat.domain.Seat;
import finalmission.seat.service.detail.SeatQueryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReservationFrontService {

    private final ReservationCommandService reservationCommandService;
    private final ReservationQueryService reservationQueryService;
    private final MemberQueryService memberQueryService;
    private final ConcertQueryService concertQueryService;
    private final SeatQueryService seatQueryService;

    public ReservationResponse create(final ReservationRequest request) {
        final Member member = memberQueryService.get(request.memberId());
        final Concert concert = concertQueryService.get(request.concertId());
        final Seat seat = seatQueryService.get(request.seatId());

        final Reservation reservation = new Reservation(
                member,
                concert,
                seat
        );

        final Reservation savedReservation = reservationCommandService.create(reservation);

        return new ReservationResponse(
                savedReservation.getId(),
                savedReservation.getMember().getId(),
                savedReservation.getConcert().getId(),
                savedReservation.getSeat().getId()
        );
    }

    public ReservationResponse get(Long id) {
        final Reservation reservation = reservationQueryService.get(id);

        return new ReservationResponse(
                reservation.getId(),
                reservation.getMember().getId(),
                reservation.getConcert().getId(),
                reservation.getSeat().getId()
        );
    }

    public List<ReservationResponse> getAll() {
        return reservationQueryService.getAll().stream()
                .map(reservation -> new ReservationResponse(
                        reservation.getId(),
                        reservation.getMember().getId(),
                        reservation.getConcert().getId(),
                        reservation.getSeat().getId()
                ))
                .toList();
    }
}
