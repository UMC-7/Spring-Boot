package umc.workbook7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.workbook7.domain.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}