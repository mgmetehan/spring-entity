package com.mgmetehan.postgresqlspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.ElementCollection;
import java.util.List;
import java.util.Map;

@Entity
@Data
@Table(name = "account_history")
@NoArgsConstructor
@AllArgsConstructor
public class AccountHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "account_history_channel", joinColumns = @JoinColumn(name = "account_history_id"), inverseJoinColumns = @JoinColumn(name = "channel_id"))
    private List<Channel> channels;

 /*   @ElementCollection
    @Column(name = "changed_cells")
    Map<String, Integer> changedCells;*/

    @Column(name = "old_values")
    private int oldValues;

    @Column(name = "new_values")
    private int newValues;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reason_id")
    private Reason reason;
}
