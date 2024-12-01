package umc.study.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class AddDTO{
        @NotBlank
        String storeName;
        @NotBlank @Size(min = 5, max = 12)
        String storeAddress;
        @NotBlank
        String regionName;
        @NotNull
        Float storeScore;

    }
}