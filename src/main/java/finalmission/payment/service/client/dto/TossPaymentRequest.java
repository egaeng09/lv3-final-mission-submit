package finalmission.payment.service.client.dto;

public record TossPaymentRequest(
        String paymentKey,
        String orderId,
        Long amount
) {
}
