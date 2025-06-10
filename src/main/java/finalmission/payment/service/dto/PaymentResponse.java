package finalmission.payment.service.dto;

public record PaymentResponse(
        Long id,
        Long reservationId,
        String paymentKey,
        String orderId,
        Long amount
) {
}
