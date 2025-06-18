package finalmission.member.service;

import finalmission.common.exception.InvalidInputException;
import finalmission.member.domain.Member;
import finalmission.member.repository.MemberRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberQueryService {

    private final MemberRepository memberRepository;

    public Member get(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new InvalidInputException("ID에 해당하는 회원을 찾을 수 없습니다."));
    }

    public List<Member> getAll() {
        return memberRepository.findAll();
    }
}
