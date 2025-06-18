package finalmission.member.service;

import finalmission.member.controller.dto.LoginRequest;
import finalmission.member.controller.dto.MemberResponse;
import finalmission.member.controller.dto.SignupRequest;
import finalmission.member.domain.Member;
import finalmission.member.service.detail.MemberCommandService;
import finalmission.member.service.detail.MemberQueryService;
import finalmission.member.service.util.JwtExtractor;
import finalmission.member.service.util.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final JwtExtractor jwtExtractor;
    private final JwtProvider jwtProvider;
    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    public MemberResponse signup(final SignupRequest request) {
        final Member member = new Member(
                request.name(),
                request.email(),
                request.password()
        );

        final Member savedMember = memberCommandService.create(member);

        return new MemberResponse(
                savedMember.getId(),
                savedMember.getName(),
                savedMember.getEmail()
        );
    }

    public String login(final LoginRequest request) {
        final Member member = memberQueryService.getByEmailAndPassword(request.email(), request.password());
        return jwtProvider.generate(member);
    }

    public Member get(final String token) {
        Long memberId = jwtExtractor.extractMemberId(token);
        return memberQueryService.get(memberId);
    }
}
