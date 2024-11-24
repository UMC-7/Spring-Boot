package umc.study.spring.repository.RegionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.spring.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Long>, RegionRepositoryCustom {
}
