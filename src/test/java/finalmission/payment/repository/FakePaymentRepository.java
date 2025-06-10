package finalmission.payment.repository;

import finalmission.payment.domain.Payment;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class FakePaymentRepository implements PaymentRepository {

    List<Payment> payments = new ArrayList<>();
    AtomicLong atomicLong = new AtomicLong(1L);


    @Override
    public Payment save(final Payment payment) {
        final Payment saved = new Payment(atomicLong.getAndIncrement(), payment.getPaymentKey(), payment.getOrderId(), payment.getAmount(), payment.getReservation(), null, null);
        payments.add(saved);
        return saved;
    }

    @Override
    public Optional<Payment> findById(final Long id) {
        return payments.stream()
                .filter(payment -> payment.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Payment> findAll() {
        return new ArrayList<>(payments);
    }
}
