package finalmission.concert.service.detail;

import finalmission.concert.domain.Concert;
import finalmission.concert.repository.ConcertRepository;
import finalmission.concert.repository.FakeConcertRepository;
import finalmission.venue.domain.Venue;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConcertCommandServiceTest {

    private ConcertRepository concertRepository = new FakeConcertRepository();
    private ConcertCommandService concertCommandService = new ConcertCommandService(concertRepository);

    @Test
    void 콘서트가_정상적으로_생성된다() {
        // Given
        final Concert concert = new Concert("Rock Concert", "시소", LocalDateTime.now(), new Venue(1L, "올공", "서울시"),
                10000L, "amazing");

        // When & Then
        final Concert actual = concertCommandService.create(concert);
        assertThat(actual.getId()).isEqualTo(1L);
    }
}
