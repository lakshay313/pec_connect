package com.pec.connect.common;

import com.pec.connect.exceptions.BaseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<Object> handleException(BaseException e) {
        Map<String, Object> res = new HashMap<>();
        res.put("errorCode", e.getErrorCode());
        res.put("errorMessage", e.getMessage());
        return new ResponseEntity<>(res, e.getHttpStatus());
    }

}
