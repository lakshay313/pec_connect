package com.pec.connect.entity;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@TypeDef(name="jsonb-node", typeClass = JsonNodeBinaryType.class)
@Table(name = "permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Type(type = "jsonb-node")
    @Column(columnDefinition = "jsonb")
    private JsonNode action;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;

}
