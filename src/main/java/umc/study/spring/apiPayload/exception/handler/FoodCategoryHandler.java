package umc.study.spring.apiPayload.exception.handler;

import umc.study.spring.apiPayload.code.BaseErrorCode;
import umc.study.spring.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(BaseErrorCode code) {
        super(code);
    }
}
