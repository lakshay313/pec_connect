package com.pec.connect.exceptions;

import lombok.Data;

@Data
public abstract class BaseException extends Exception {

    public abstract int getErrorCode();

    public BaseException(String message) {
        super(message);
    }

}
