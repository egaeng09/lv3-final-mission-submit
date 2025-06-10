package finalmission.concert.repository;

import finalmission.concert.domain.Concert;
import java.util.List;
import java.util.Optional;

public interface ConcertRepository {

    Concert save(Concert concert);

    Optional<Concert> findById(Long id);

    List<Concert> findAll();
}
