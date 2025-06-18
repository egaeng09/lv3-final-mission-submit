package finalmission.member.domain;

import finalmission.common.exception.InvalidInputException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Email
    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Column(nullable = false, length = 50)
    private String password;

    public Member(final String name, final String email, final String password) {
        validate(name, email, password);
        this.name = name;
        this.email = email;
        this.password = password;
    }

    private void validate(
            final String name,
            final String email,
            final String password
    ) {
        if (name == null || name.isBlank()) {
            throw new InvalidInputException("이름은 null이거나 빈 값일 수 없습니다.");
        }
        if (email == null || email.isBlank()) {
            throw new InvalidInputException("이메일은 null이거나 빈 값일 수 없습니다.");
        }
        if (password == null || password.isBlank()) {
            throw new InvalidInputException("비밀번호는 null이거나 빈 값일 수 없습니다.");
        }
    }
}
