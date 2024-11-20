package umc.workbook7.apiPayload.exception.handler;

import umc.workbook7.apiPayload.code.BaseErrorCode;
import umc.workbook7.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}