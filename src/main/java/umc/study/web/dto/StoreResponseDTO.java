package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class StoreResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddStoreResultDTO {
        Long storeId;
        String storeName;
        String regionName;
        Float storeScore;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StoreMissionDTO {
        Long missionId;
        Integer reward;
        String missionSpec;
        LocalDate deadline;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StoreMissionListDTO {
        List<StoreMissionDTO> missions;
        Integer totalPages;
        Long totalElements;
        Boolean isLast;
        Boolean isFirst;
    }
}