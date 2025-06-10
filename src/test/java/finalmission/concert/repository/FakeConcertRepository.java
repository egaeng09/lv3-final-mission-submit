package finalmission.concert.repository;

import finalmission.concert.domain.Concert;
import finalmission.concert.repository.ConcertRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class FakeConcertRepository implements ConcertRepository {

    List<Concert> concerts = new ArrayList<>();
    AtomicLong atomicLong = new AtomicLong(1L);


    @Override
    public Concert save(final Concert concert) {
        final Concert saved = new Concert(
                atomicLong.getAndIncrement(),
                concert.getTitle(),
                concert.getArtist(),
                concert.getConcertDate(),
                concert.getVenue(),
                concert.getPrice(),
                concert.getDescription()
        );
        concerts.add(saved);
        return saved;
    }

    @Override
    public Optional<Concert> findById(final Long id) {
        return concerts.stream()
                .filter(concert -> concert.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Concert> findAll() {
        return new ArrayList<>(concerts);
    }
}
