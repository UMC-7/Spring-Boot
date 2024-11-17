package UMC._th.apiPayload.exception.handler;

import UMC._th.apiPayload.code.BaseErrorCode;
import UMC._th.apiPayload.exception.GeneralException;

public class FoodPreferHandler extends GeneralException {

    public FoodPreferHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
