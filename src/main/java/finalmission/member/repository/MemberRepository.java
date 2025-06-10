package finalmission.member.repository;

import finalmission.member.domain.Member;
import finalmission.reservation.domain.Reservation;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    Optional<Member> findById(Long id);

    List<Member> findAll();
}
