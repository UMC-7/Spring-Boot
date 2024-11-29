// 클라이언트가 서버로 보내는 요청 데이터를 캡슐화 한다.
// 요청 데이터를 정의
// 클라이언트가 보내야 할 데이터의 구조와 제약 조건을 포함
// 검증 어노테이션을 통해 데이터 유효성 검사

package umm.spring.study.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import umm.spring.study.domain.enums.Role;
import umm.spring.study.validation.annotation.ExistCategories;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    @Setter
    public static class JoinDto{
        // @NotBlank는 값이 반드시 존재하고, 공백 문자열이나 빈 문자열은 허용하지 않음
        // 문자열에서만 사용가능
        @NotBlank
        String name;

        // @NotNull은 값이 반드시 존재해야 하지만, 빈 문자열이나 공백 문자열은 허용
        @NotNull
        Integer gender;
        @NotNull
        Integer birthYear;
        @NotNull
        Integer birthMonth;
        @NotNull
        Integer birthDay;
        @Size(min = 1, max = 12)
        String address;
        @Size(min = 1, max = 12)
        String specAddress;
        @ExistCategories
        List<Long> preferCategory;
        @NotBlank
        @Email
        String email;
        @NotBlank
        String password;
        @NotNull
        Role role;
    }
}
