package umc.workbook7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.workbook7.domain.entity.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
}
