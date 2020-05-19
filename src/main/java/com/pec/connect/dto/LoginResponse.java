package com.pec.connect.dto;

import lombok.Data;

import java.util.Date;

@Data
public class LoginResponse {

    private Long id;

    private Long sid;

    private String firstName;

    private String lastName;

    private String email;

    private String access_token;

    private Date createdAt;
}
