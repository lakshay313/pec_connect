package com.pec.connect.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    AUTHENTICATION_FAILED(1),

    UNAUTHORIZED(2),

    MAPPING_NOT_FOUND(3);

    private int value;
}
