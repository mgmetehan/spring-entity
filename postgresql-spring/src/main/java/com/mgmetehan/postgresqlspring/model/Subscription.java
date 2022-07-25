package com.mgmetehan.postgresqlspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "subscription_channel", joinColumns = @JoinColumn(name = "subscription_id"), inverseJoinColumns = @JoinColumn(name = "channel_id"))
    private List<Channel> channels;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "package_id")
    private Package packages;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subscription_status_id")
    private SubscriptionStatus subscriptionStatus;

    private Double price;


    @Column(name = "license_count")
    private int licenseCount;

    @Column(name = "used_license_count")
    private int usedLicenseCount;

    @Enumerated
    @Column(name = "subscription_type")
    private Type type;

    @Column(name = "sardis_id")
    private Long sardisId;

    @Column(name = "with_drawal_fee")
    private Double withDrawalFee;


    @OneToMany(mappedBy = "subscriptions", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserPackages> userPackagesList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    @OneToOne(mappedBy = "subscription", cascade = CascadeType.ALL)
    private SubscriptionHistory subscriptionHistory;

    enum Type {
    }

}
