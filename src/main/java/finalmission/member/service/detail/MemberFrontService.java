package finalmission.member.service.detail;

import finalmission.member.controller.dto.MemberRequest;
import finalmission.member.controller.dto.MemberResponse;
import finalmission.member.domain.Member;
import finalmission.member.service.MemberQueryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberFrontService {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    public MemberResponse create(final MemberRequest request) {
        final Member member = new Member(request.name());

        final Member savedMember = memberCommandService.create(member);

        return new MemberResponse(
                savedMember.getId(),
                savedMember.getName()
        );
    }

    public MemberResponse get(Long id) {
        final Member member = memberQueryService.get(id);

        return new MemberResponse(
                member.getId(),
                member.getName()
        );
    }

    public List<MemberResponse> getAll() {
        return memberQueryService.getAll().stream()
                .map(member -> new MemberResponse(
                        member.getId(),
                        member.getName()
                ))
                .toList();
    }
}
