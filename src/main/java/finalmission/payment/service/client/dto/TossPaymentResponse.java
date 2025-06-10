package finalmission.payment.service.client.dto;

public record TossPaymentResponse(
        String paymentKey,
        String orderId,
        Long amount,
        String requestedAt,
        String approvedAt
) {
}
