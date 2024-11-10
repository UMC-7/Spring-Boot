package umc.study.spring.repository.StoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.spring.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}
