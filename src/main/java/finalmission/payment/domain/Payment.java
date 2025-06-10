package finalmission.payment.domain;

import finalmission.reservation.domain.Reservation;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 200)
    private String paymentKey;

    @Column(nullable = false, length = 64)
    private String orderId;

    @Column(nullable = false)
    private Long amount;

    @OneToOne
    @JoinColumn(nullable = false)
    private Reservation reservation;

    private String requestedAt;

    private String approvedAt;

    public Payment(final String paymentKey, final String orderId, final Long amount, final Reservation reservation) {
        validate(paymentKey, orderId, amount, reservation);
        this.paymentKey = paymentKey;
        this.orderId = orderId;
        this.amount = amount;
        this.reservation = reservation;
    }

    public Payment(final String paymentKey, final String orderId, final Long amount, final Reservation reservation,
                   final String requestedAt,
                   final String approvedAt) {
        validate(paymentKey, orderId, amount, reservation);
        this.paymentKey = paymentKey;
        this.orderId = orderId;
        this.amount = amount;
        this.reservation = reservation;
        this.requestedAt = requestedAt;
        this.approvedAt = approvedAt;
    }

    public void validate(final String paymentKey, final String orderId, final Long amount, final Reservation reservation) {
        if (paymentKey == null || paymentKey.isEmpty()) {
            throw new IllegalArgumentException("paymentKey는 null이거나 빈 값일 수 없습니다.");
        }
        if (orderId == null || orderId.isEmpty()) {
            throw new IllegalArgumentException("orderId는 null이거나 빈 값일 수 없습니다.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("amount는 0보다 커야 합니다.");
        }
        if (reservation == null) {
            throw new IllegalArgumentException("reservation은 null일 수 없습니다.");
        }
    }
}
