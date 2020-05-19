package com.pec.connect.exceptions;

import com.pec.connect.enums.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class AuthenticationFailedException extends BaseException {

    public AuthenticationFailedException(String message) {
        super(message);
    }

    @Override
    public int getErrorCode() {
        return ErrorCode.UNAUTHORIZED.getValue();
    }

    @Override
    public HttpStatus getHttpStatus(){
        return HttpStatus.FORBIDDEN;
    }
}
