package com.pec.connect.exceptions;

import org.springframework.http.HttpStatus;

public abstract class BaseException extends Exception {

    public abstract int getErrorCode();

    public abstract HttpStatus getHttpStatus();

    public BaseException(String message) {
        super(message);
    }

}
