package umc.spring.repository.StoreRepository;

import umc.spring.domain.common.Store;

import java.util.List;

public interface StoreRepositoryCustom {

    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}