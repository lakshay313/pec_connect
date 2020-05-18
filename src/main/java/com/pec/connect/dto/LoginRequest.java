package com.pec.connect.dto;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginRequest {
    @NotNull
    private String uid;

    @NotNull
    private String password;
}
