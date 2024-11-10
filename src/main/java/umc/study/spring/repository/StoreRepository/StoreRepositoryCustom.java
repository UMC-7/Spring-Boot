package umc.study.spring.repository.StoreRepository;

import umc.study.spring.domain.Store;

import java.util.List;

public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name,Float score);
}
