package umc.study.spring.repository.RegionRepository;

import umc.study.spring.domain.Region;

public interface RegionRepositoryCustom {
    Region findByName(String name);
}