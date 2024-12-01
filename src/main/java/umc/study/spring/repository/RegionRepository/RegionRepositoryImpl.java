package umc.study.spring.repository.RegionRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.spring.domain.Region;

@Repository
@RequiredArgsConstructor
public class RegionRepositoryImpl implements RegionRepositoryCustom {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Region findByName(String name) {
        String jpql = "SELECT r FROM Region r WHERE r.name = :name";
        return entityManager.createQuery(jpql, Region.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
