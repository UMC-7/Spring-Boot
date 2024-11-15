package umm.spring.study.apiPayload.exception.handler;

import umm.spring.study.apiPayload.code.BaseErrorCode;
import umm.spring.study.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
