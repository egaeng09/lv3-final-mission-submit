package finalmission.venue.repository;

import finalmission.venue.domain.Venue;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

class FakeVenueRepository implements VenueRepository {

    List<Venue> venues = new ArrayList<>();
    AtomicLong atomicLong = new AtomicLong(1L);


    @Override
    public Venue save(final Venue venue) {
        final Venue saved = new Venue(atomicLong.getAndIncrement(), venue.getName(), venue.getAddress());
        venues.add(saved);
        return saved;
    }

    @Override
    public Optional<Venue> findById(final Long id) {
        return venues.stream()
                .filter(venue -> venue.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Venue> findAll() {
        return new ArrayList<>(venues);
    }
}
