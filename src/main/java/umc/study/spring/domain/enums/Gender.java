package umc.study.spring.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {
    MALE("남성"),
    FEMALE("여성"),
    NONE("미선택");

    private final String value;

    Gender(String value) {
        this.value = value;
    }

    @JsonValue // JSON 응답 시 한글 값 반환
    public String getValue() {
        return value;
    }

    @JsonCreator // JSON 요청 시 한글 값을 Enum으로 변환
    public static Gender fromValue(String value) {
        for (Gender gender : Gender.values()) {
            if (gender.value.equalsIgnoreCase(value)) {
                return gender;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + value);
    }
}
