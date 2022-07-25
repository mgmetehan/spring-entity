package com.mgmetehan.postgresqlspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "user_history")
@NoArgsConstructor
@AllArgsConstructor
public class UserHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "changed_user_id")

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_history_channel", joinColumns = @JoinColumn(name = "user_history_id"), inverseJoinColumns = @JoinColumn(name = "channel_id"))
    private List<Channel> channels;

 /*   @ElementCollection
    @Column(name = "changed_cells")
    Map<String, Integer> changedCells;*/

    @Column(name = "old_values")
    private int oldValues;

    @Column(name = "new_values")
    private int newValues;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reason_id")
    private Reason reason;

}
