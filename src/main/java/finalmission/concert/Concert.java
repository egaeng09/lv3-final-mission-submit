package finalmission.concert;

import finalmission.venue.Venue;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
public class Concert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 50)
    private String artist;

    private LocalDateTime concertDate;

    @OneToOne
    @JoinColumn(nullable = false)
    private Venue venue;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false, length = 200)
    private String description;
}
