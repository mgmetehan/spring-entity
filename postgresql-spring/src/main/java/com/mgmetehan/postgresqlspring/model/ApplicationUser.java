package com.mgmetehan.postgresqlspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "application_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_secret")
    private String clientSecret;

    @Column(name = "client_key")
    private String clientKey;

    @OneToMany(mappedBy = "applicationUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ExternalRequestLog> log = new ArrayList<>();

}
