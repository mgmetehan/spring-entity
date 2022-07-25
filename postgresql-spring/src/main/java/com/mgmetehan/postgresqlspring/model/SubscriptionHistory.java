package com.mgmetehan.postgresqlspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "subscription_history")
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subscription_id")
    private Subscription subscription;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "subscriptionHistory_channel", joinColumns = @JoinColumn(name = "subscription_history_id"), inverseJoinColumns = @JoinColumn(name = "channel_id"))
    private List<Channel> channels;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reason_id")
    private Reason reason;

    @Column(name = "new_license_count")
    private int newLicenseCount;

    @Column(name = "old_license_count")
    private int oldLicenseCount;

    @Column(name = "old_price")
    private Double oldPrice;

    @Column(name = "new_price")
    private Double newPrice;

}
