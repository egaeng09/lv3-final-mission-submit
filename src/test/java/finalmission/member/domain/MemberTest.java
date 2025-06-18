package finalmission.member.domain;

import finalmission.common.exception.InvalidInputException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

class MemberTest {

    @Test
    void 회원이_생성된다() {
        // Given
        final String name = "siso";

        // When
        final Member actual = new Member(name);

        // Then
        assertThat(actual.getName()).isEqualTo(name);
    }

    @Test
    void 회원의_이름이_null_또는_빈값이_아니라면_예외가_발생하지_않는다() {
        // Given
        final String name = "siso";

        // When & Then
        assertThatNoException().isThrownBy(() -> new Member(name));
    }

    @Test
    void 회원의_이름이_null_또는_빈값이라면_예외가_발생한다() {
        // Given
        final String emptyValue = "";
        final String nullValue = null;

        // When & Then
        assertSoftly(softAssertions -> {
            softAssertions.assertThatThrownBy(() -> new Member(nullValue))
                    .isInstanceOf(InvalidInputException.class)
                    .hasMessageContaining("이름은 null이거나 빈 값일 수 없습니다.");
            softAssertions.assertThatThrownBy(() -> new Member(emptyValue))
                    .isInstanceOf(InvalidInputException.class)
                    .hasMessageContaining("이름은 null이거나 빈 값일 수 없습니다.");
        });
    }
}
