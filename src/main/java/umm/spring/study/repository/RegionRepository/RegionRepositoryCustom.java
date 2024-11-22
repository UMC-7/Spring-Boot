package umm.spring.study.repository.RegionRepository;

import com.querydsl.jpa.impl.JPAQuery;
import umm.spring.study.domain.Region;

import java.util.Optional;

public interface RegionRepositoryCustom {
    Region findByName(String name);
}
