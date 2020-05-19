package com.pec.connect.dto;

import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;

@Data
@TypeDef(name = "jsonb-node", typeClass = JsonNodeBinaryType.class)
public class Access {

    private String resource;

    @Type(type = "jsonb-node")
    @Column(columnDefinition = "jsonb")
    private JsonNode action;
}
