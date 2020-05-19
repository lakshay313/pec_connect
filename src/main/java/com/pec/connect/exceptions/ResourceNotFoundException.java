package com.pec.connect.exceptions;

import com.pec.connect.enums.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ResourceNotFoundException extends BaseException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    @Override
    public int getErrorCode() {
        return ErrorCode.UNAUTHORIZED.getValue();
    }
}
