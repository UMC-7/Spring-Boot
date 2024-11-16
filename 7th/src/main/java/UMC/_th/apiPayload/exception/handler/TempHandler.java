package UMC._th.apiPayload.exception.handler;

import UMC._th.apiPayload.code.BaseErrorCode;
import UMC._th.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
