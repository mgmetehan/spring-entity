package com.mgmetehan.postgresqlspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "subscription_status")
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated
    private Name name;

    @OneToOne(mappedBy = "subscriptionStatus", cascade = CascadeType.ALL)
    private Subscription subscriptions;

    enum Name {
        ACTIVE,DEACTIVE,GRACE_PERIOD,SUSPEND;
    }
}
