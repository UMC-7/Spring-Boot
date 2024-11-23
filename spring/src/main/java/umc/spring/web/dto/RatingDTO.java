package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class RatingDTO {

    @Getter
    public static class CreateRating {

        @NotNull
        Integer rate;

        String ratingContent;

        @NotNull
        Long missionId;

        @NotNull
        Long memberId;

        @NotNull
        Long storeId;
    }
}
