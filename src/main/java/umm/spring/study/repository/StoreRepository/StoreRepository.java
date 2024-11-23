package umm.spring.study.repository.StoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umm.spring.study.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
    boolean existsById(Long id);
}
