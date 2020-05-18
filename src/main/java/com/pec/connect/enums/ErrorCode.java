package com.pec.connect.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    AUTHENTICATION_FAILED(1),

    UNAUTHORIZED(2);

    private int value;
}
