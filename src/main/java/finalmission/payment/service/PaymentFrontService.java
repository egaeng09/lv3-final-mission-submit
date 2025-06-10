package finalmission.payment.service;

import finalmission.payment.domain.Payment;
import finalmission.payment.service.client.TossPaymentClient;
import finalmission.payment.service.client.dto.TossPaymentRequest;
import finalmission.payment.service.client.dto.TossPaymentResponse;
import finalmission.payment.service.detail.PaymentCommandService;
import finalmission.payment.service.detail.PaymentQueryService;
import finalmission.payment.service.dto.PaymentResponse;
import finalmission.reservation.controller.dto.ReservationResponse;
import finalmission.reservation.domain.Reservation;
import finalmission.reservation.service.detail.ReservationQueryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PaymentFrontService {

    private final PaymentCommandService paymentCommandService;
    private final PaymentQueryService paymentQueryService;
    private final TossPaymentClient tossPaymentClient;
    private final ReservationQueryService reservationQueryService;

    public PaymentResponse create(final PaymentResponse request) {
        final TossPaymentRequest tossPaymentRequest= new TossPaymentRequest(
                request.paymentKey(),
                request.orderId(),
                request.amount()
        );

        final TossPaymentResponse tossPaymentResponse = tossPaymentClient.confirm(tossPaymentRequest);

        final Reservation reservation = reservationQueryService.get(request.reservationId());

        Payment payment = new Payment(
                tossPaymentResponse.paymentKey(),
                tossPaymentResponse.orderId(),
                tossPaymentResponse.amount(),
                reservation
        );

        final Payment savedPayment = paymentCommandService.create(payment);

        return new PaymentResponse(
                savedPayment.getId(),
                savedPayment.getReservation().getId(),
                savedPayment.getPaymentKey(),
                savedPayment.getOrderId(),
                savedPayment.getAmount()
        );
    }

    public PaymentResponse get(Long id) {
        final Payment payment = paymentQueryService.get(id);

        return new PaymentResponse(
                payment.getId(),
                payment.getReservation().getId(),
                payment.getPaymentKey(),
                payment.getOrderId(),
                payment.getAmount()
        );
    }
}
