package umc.spring.web.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.domain.common.Store;
import umc.spring.domain.mapping.MemberMission;

import java.util.ArrayList;
import java.util.List;

public class MissionDTO {

    @Getter
    public static class AddDTO {

        String missionName;

        String missionCertificationNumber;

        Long storeId;

        List<Long> memberMisssion;
    }

    @Getter
    public static class AddTryDTO {

        @NotNull
        Long missionId;

        @NotNull
        Long memberId;
    }
}
