package umc.study.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.repository.MemberRepository;
import umc.study.repository.MyReviewRepository.MyReviewRepository;

@Service
@RequiredArgsConstructor
public class UserReviewQueryService {

    private final MemberRepository memberRepository;
    private final MyReviewRepository reviewRepository;

    public Page<Review> getUserReviews(Long userId, Integer page) {
        Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        return reviewRepository.findAllByMember(member, PageRequest.of(page - 1, 10));
    }
}
