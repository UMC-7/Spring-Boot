package umc.spring.apiPayload.code;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorReasonDTO {

    private final boolean inSuccess;
    private final String code;
    private final String message;

    public boolean getIsSuccess() {return isInSuccess();}

}
