package com.mgmetehan.postgresqlspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "system_parameters")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemParameters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int key;

    private String value;

    @Lob
    private String description;
}
