package umm.spring.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umm.spring.study.validation.annotation.ExistStore;

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
        @NotNull
        @ExistStore
        Long storeId;

    }
}
