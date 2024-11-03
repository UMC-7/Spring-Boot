package umm.spring.study.repository.StoreRepository;

import umm.spring.study.domain.Store;

import java.util.List;


public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}
