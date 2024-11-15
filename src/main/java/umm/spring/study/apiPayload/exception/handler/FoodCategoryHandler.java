package umm.spring.study.apiPayload.exception.handler;

import umm.spring.study.apiPayload.code.BaseErrorCode;
import umm.spring.study.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
