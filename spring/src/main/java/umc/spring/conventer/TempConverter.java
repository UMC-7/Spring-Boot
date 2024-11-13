package umc.spring.conventer;

import umc.spring.web.dto.TempResponse;

public class TempConverter {

    public static TempResponse.TempTestDTO toTempTestDTO() {
        return TempResponse.TempTestDTO.builder()
                .testString("this is Test!")
                .build();
    }
}
