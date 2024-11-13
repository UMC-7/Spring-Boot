package umc.study.spring.apiPayload.exception.handler;

import umc.study.spring.apiPayload.code.BaseErrorCode;
import umc.study.spring.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode code) {
        super(code);
    }
}
