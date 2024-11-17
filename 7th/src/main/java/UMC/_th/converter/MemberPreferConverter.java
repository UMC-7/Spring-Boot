package UMC._th.converter;

import UMC._th.domain.FoodPrefer;
import UMC._th.domain.mapping.MemberPrefer;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {

    public static List<MemberPrefer> toMemberPreferList(List<FoodPrefer> prefers) {
        return prefers.stream()
                .map(foodCategory->
                        MemberPrefer.builder()
                                .foodPrefer(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
