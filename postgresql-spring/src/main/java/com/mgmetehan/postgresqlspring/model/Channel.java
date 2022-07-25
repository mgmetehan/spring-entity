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
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated
    private Name name;

    @ManyToMany(mappedBy = "channels", fetch = FetchType.LAZY)
    private List<Account> accounts;

    @ManyToMany(mappedBy = "channels", fetch = FetchType.LAZY)
    private List<User> users;

    @ManyToMany(mappedBy = "channels", fetch = FetchType.LAZY)
    private List<Privilege> privileges;

    @OneToMany(mappedBy = "channel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<KafkaEventLog> kafkaEventLog = new ArrayList<>();

    @ManyToMany(mappedBy = "channels", fetch = FetchType.LAZY)
    private List<Subscription> subscriptions = new ArrayList<>();

    @ManyToMany(mappedBy = "channels", fetch = FetchType.LAZY)
    private List<SubscriptionHistory> subscriptionHistory = new ArrayList<>();

    @ManyToMany(mappedBy = "channels", fetch = FetchType.LAZY)
    private List<AccountHistory> accountHistories;

    @ManyToMany(mappedBy = "channels", fetch = FetchType.LAZY)
    private List<UserHistory> userHistories;

    @ManyToMany(mappedBy = "channels", fetch = FetchType.LAZY)
    private List<UserPackagesHistory> userPackagesHistories;
    enum Name {
        DBS, YAANI, BIP_MEET, LIFE_BOX, SUIT;
    }
}
