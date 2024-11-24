package umc.study.web.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class AddStoreDTO {

        @NotBlank
        String storeName;
        @NotBlank
        String storeAddress;
        @NotBlank
        String regionName;

        @Min(0) @Max(5)
        Float storeScore;
    }
}
