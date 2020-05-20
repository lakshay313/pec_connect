package com.pec.connect.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.Date;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class LoginResponse {

    private Long id;

    private Long sid;

    private String firstName;

    private String lastName;

    private String email;

    private String access_token;

    private Date createdAt;
}
