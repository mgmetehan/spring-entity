package com.mgmetehan.postgresqlspring.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sardis_id")
    private Long sardisId;

    private String name;

    @Lob
    private String description;

    private Double price;

    private String priority;

    @OneToMany(mappedBy = "packages", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserPackages> userPackagesList = new ArrayList<>();

    @OneToMany(mappedBy = "packages", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Subscription> subscriptions = new ArrayList<>();
}
