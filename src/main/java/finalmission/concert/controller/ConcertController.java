package finalmission.concert.controller;

import finalmission.concert.controller.dto.ConcertRequest;
import finalmission.concert.controller.dto.ConcertResponse;
import finalmission.concert.service.ConcertFrontService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/concerts")
public class ConcertController {

    private final ConcertFrontService concertFrontService;

    @PostMapping
    public ResponseEntity<ConcertResponse> createConcert(@RequestBody final ConcertRequest request) {
        return ResponseEntity.ok(concertFrontService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConcertResponse> getConcert(@PathVariable final Long id) {
        return ResponseEntity.ok(concertFrontService.get(id));
    }

    @GetMapping
    public List<ConcertResponse> getAllConcert() {
        return concertFrontService.getAll();
    }
}
