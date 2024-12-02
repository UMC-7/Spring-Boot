package UMC._th.web.dto;

import UMC._th.domain.enums.Role;
import UMC._th.validation.annotation.ExistCategories;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    @Setter
    public static class JoinDTO{
        @NotBlank
        String name;
        @NotBlank
        @Email
        String email;
        @NotBlank
        String password;
        @NotNull
        Role role;
        @NotNull
        Integer gender;
        @NotNull
        Integer birthYear;
        @NotNull
        Integer birthMonth;
        @NotNull
        Integer birthDay;
        @Size(min = 5, max = 12)
        String address;
        @Size(min = 5, max = 12)
        String specAddress;
        Boolean agreement;
        @ExistCategories
        List<Long> preferCategory;
    }
}
