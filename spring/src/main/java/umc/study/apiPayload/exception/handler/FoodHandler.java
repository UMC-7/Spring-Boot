package umc.spring.study.apiPayload.exception.handler;

import umc.spring.study.apiPayload.code.BaseErrorCode;
import umc.spring.study.apiPayload.exception.GeneralException;

public class FoodHandler extends GeneralException {
    public FoodHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}