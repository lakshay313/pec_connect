package com.pec.connect.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleType {

    ADMIN("Admin"),

    USER("User");

    String name;
}
