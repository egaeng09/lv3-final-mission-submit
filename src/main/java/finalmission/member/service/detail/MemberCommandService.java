package finalmission.member.service.detail;

import finalmission.member.domain.Member;
import finalmission.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberCommandService {

    private final MemberRepository memberRepository;

    public Member create(final Member member) {
        return memberRepository.save(member);
    }
}
