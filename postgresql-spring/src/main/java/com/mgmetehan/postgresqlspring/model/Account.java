package com.mgmetehan.postgresqlspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dss_crm_id")
    private Long dssCrmId;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "account_channel", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "channel_id"))
    private List<Channel> channels;

    @Enumerated
    private Type type;

    private String name;

    private String hostname;

    @Enumerated
    private IdType idType;

    @Column(name = "id_value")
    private int idValue;

    private String ncst;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private AccountDomain accountDomain;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AuthenticationMethod> authenticationMethods = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "account_privilegeGroup", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "privilege_group_id"))
    private List<PrivilegeGroup> privilegeGroups;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Subscription> subscriptions = new ArrayList<>();

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AccountAddress> accountAddresses = new ArrayList<>();

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private AccountHistory accountHistory;

    enum IdType {
        TCKN, VKN
    }

    enum Type {
        INDIVIDUAL, CORPORATE
    }
}
