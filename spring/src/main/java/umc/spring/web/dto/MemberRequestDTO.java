package umc.spring.web.dto;

import lombok.Getter;
import umc.spring.validation.annotation.ExistCategories;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto {
        String name;
        Integer gender;
        Integer birthYear;
        Integer birthMonth;
        Integer birthDay;
        String address;
        String specAddress;
        @ExistCategories
        List<Long> memberPreferList;  //음식 선호의 id값을 넘겨준다.
    }
}