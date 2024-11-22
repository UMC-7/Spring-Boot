package umm.spring.study.repository.RegionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umm.spring.study.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Long>, RegionRepositoryCustom {
}
