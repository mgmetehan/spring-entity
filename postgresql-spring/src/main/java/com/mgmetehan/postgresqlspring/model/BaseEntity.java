package com.mgmetehan.postgresqlspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "base_entity")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "crated_date")
    private Date createDate = new Date();

    @Column(name = "created_by")
    private String createdBy;

    private Boolean enable;

    @Column(name = "id_deleted")
    private Long idDeleted;

    @Column(name = "transaction_id")
    private Long transcationId;


}

