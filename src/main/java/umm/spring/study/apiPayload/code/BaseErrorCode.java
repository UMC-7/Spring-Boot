package umm.spring.study.apiPayload.code;

public interface BaseErrorCode {

    ErrorReasonDTO getReason();

    ErrorReasonDTO getReasonHttpStatus();
}
