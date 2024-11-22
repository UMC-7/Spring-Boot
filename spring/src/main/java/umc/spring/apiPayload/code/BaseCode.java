package umc.spring.apiPayload.code;

import java.awt.desktop.UserSessionEvent;
import java.security.cert.CertPathValidatorException;


public interface BaseCode {

    ReasonDTO getReason();

    ReasonDTO getReasonHttpStatus();
}


/**
 * 구체화 하는 Status에서 두개의 메소드를 반드시 Override할 것을 강요한다.
 */