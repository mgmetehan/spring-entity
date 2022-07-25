package com.mgmetehan.postgresqlspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authentication_method")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    private String url;

    private String type;

    private String username;

    private String password;

    @Column(name = "ldap_search_base")
    private String ldapSearchBase;

    @Column(name = "ldap_search_query")
    private String ldapSearchQuery;

    @Column(name = "ldap_password_attribute")
    private String ldapPasswordAttribute;

}
