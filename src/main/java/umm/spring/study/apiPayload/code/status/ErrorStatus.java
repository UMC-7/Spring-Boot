package umm.spring.study.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umm.spring.study.apiPayload.code.BaseErrorCode;
import umm.spring.study.apiPayload.code.ErrorReasonDTO;
import umm.spring.study.domain.Store;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    // 열거형의 상수 - 각 열거 상수는 생성자 인수로 필드 값을 설정
    // () 안의 값들을 열거형 생성자에 전달하여 상수의 고유한 상태 정보를 초기화
    // 가장 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),


    // 멤버 관련 에러
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 없습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002", "닉네임은 필수 입니다."),

    // 예시,,,
    ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, "ARTICLE4001", "게시글이 없습니다."),

    // For test
    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "이거는 테스트"),

    // 음식 카테고리 관련 에러
    FOOD_CATEGORY_NOT_FOUND(HttpStatus.BAD_REQUEST, "FOODCATEGORY4001", "음식 카테고리 미설정."),

    // 미션 아이디 관련 에러
    MISSION_CATEGORY_NOT_FOUND(HttpStatus.BAD_REQUEST, "MISSION4001", "미션 아이디 없음."),

    // 가게 없음 에러
    STORE_NOT_FOUND(HttpStatus.BAD_REQUEST, "STORE4001", "가게 없음.");
    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build()
                ;
    }
}
