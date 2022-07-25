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
public class Reason {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Lob
    private String description;

    @OneToMany(mappedBy = "reason", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SubscriptionHistory> subscriptionHistory = new ArrayList<>();

    @OneToMany(mappedBy = "reason", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AccountHistory> accountHistories = new ArrayList<>();

    @OneToMany(mappedBy = "reason", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserHistory> userHistories = new ArrayList<>();
}
