package umc.spring.study.converter;

import umc.spring.study.domain.Food;
import umc.spring.study.domain.mapping.MemberFood;

import java.util.List;
import java.util.stream.Collectors;

public class MemberFoodConverter {

    public static List<MemberFood> toMemberFoodList(List<Food> foodList){

        return foodList.stream()
                .map(category ->
                        MemberFood.builder()
                                .food(category)
                                .build()
                ).collect(Collectors.toList());
    }
}
