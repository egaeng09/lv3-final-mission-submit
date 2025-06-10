package finalmission.payment.service.dto;

public record PaymentRequest(
        Long reservationId,
        String paymentKey,
        String orderId,
        Long amount
) {
}
