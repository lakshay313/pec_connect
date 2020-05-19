package com.pec.connect.exceptions;

import com.pec.connect.enums.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class IdentityNotFoundException extends BaseException {

    public IdentityNotFoundException(String message) {
        super(message);
    }

    @Override
    public int getErrorCode() {
        return ErrorCode.AUTHENTICATION_FAILED.getValue();
    }

}
