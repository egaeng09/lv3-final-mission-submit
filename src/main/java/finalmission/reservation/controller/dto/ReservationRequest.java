package finalmission.reservation.controller.dto;

public record ReservationRequest(
        Long memberId,
        Long concertId,
        Long seatId
) {
}
