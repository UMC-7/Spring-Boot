package umm.spring.study.converter;

import umm.spring.study.web.dto.TempResponse;

public class TempConverter {

    public static TempResponse.TempTestDTO toTempTestDTO(){
        return TempResponse.TempTestDTO.builder() // TempResponse.TempTestDTO 클래스에 빌더 패턴이 적용되어 있으니 builder()를 호출하여 빌더 객체 생성
                .testString("This is Test!")
                .build(); // build() 메서드는 설정된 값을 바탕으로 최종 TempTestDTO 객체를 생성하여 반환
    }

    public static TempResponse.TempExceptionDTO toTempExceptionDTO(Integer flag){
        return TempResponse.TempExceptionDTO.builder()
                .flag(flag)
                .build();
    }
}
