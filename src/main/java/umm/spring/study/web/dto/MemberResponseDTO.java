// 서버에서 클라이엍느로 보내는 응답 데이터를 캡슐화
// 응답 데이터를 정의
// 클라이언트가 받을 데이터의 구조를 설정
// 요청 처리 결과를 클라이언트에게 반환

package umm.spring.study.web.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class MemberResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    // 여기 안의 변수들이 추후 프론트로 보낼 API 응답의 데이터로 사용됨
    public static class JoinResultDTO{
        Long memberId;
        LocalDateTime createdAt;
    }
}
