package com.pec.connect.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RecordType {

    BOOK("book"),

    NOTES("notes"),

    ASSIGNMENT("assignment");

    private String name;
}
