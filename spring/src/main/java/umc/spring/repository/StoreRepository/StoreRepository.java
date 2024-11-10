package umc.spring.repository.StoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.common.Store;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}
