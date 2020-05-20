package com.pec.connect.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.pec.connect.enums.RecordType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
@Entity
@Table(name = "record")
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    @Enumerated(EnumType.STRING)
    private RecordType type;

    private String edition;

    @NotNull
    private String category;

    @NotNull
    private String specialisation;

    @NotNull
    private String path;

    private String postedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date postedAt;

}
