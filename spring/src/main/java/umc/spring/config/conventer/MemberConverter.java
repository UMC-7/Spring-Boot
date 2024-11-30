package umc.spring.config.conventer;

import org.springframework.data.domain.Page;
import umc.spring.domain.common.Member;
import umc.spring.domain.common.Rating;
import umc.spring.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MemberResponseDTO.myRatingListResultDTO toMyRatingListResultDTO(Page<Rating> ratingList) {

        List<MemberResponseDTO.myRatingResultDTO> ratingResultDTOS = ratingList.stream()
                .map(MemberConverter::toRatingResultDTO).collect(Collectors.toList());

        return MemberResponseDTO.myRatingListResultDTO.builder()
                .isFirst(ratingList.isFirst())
                .isLast(ratingList.isLast())
                .totalPage(ratingList.getTotalPages())
                .totalElements(ratingList.getTotalElements())
                .listSize(ratingList.getSize())
                .ratingList(ratingResultDTOS)
                .build();


    }

    public static MemberResponseDTO.myRatingResultDTO toRatingResultDTO(Rating rating) {
        return MemberResponseDTO.myRatingResultDTO.builder()
                .storeName(rating.getStore().getStoreName())
                .score(Float.valueOf(rating.getRate()))
                .createdAt(rating.getCreatedAt().toLocalDate())
                .body(rating.getRatingContent())
                .build();

    }
}
