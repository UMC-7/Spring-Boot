package umc.study.spring.repository.RegionRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.spring.domain.QRegion;
import umc.study.spring.domain.Region;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RegionRepositoryImpl implements RegionRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;
    private final QRegion region = QRegion.region;

    @Override
    public Region findByName(String name) {
        return jpaQueryFactory
                .selectFrom(region)
                .where(region.name.eq(name))
                .fetchOne();
    }
}
