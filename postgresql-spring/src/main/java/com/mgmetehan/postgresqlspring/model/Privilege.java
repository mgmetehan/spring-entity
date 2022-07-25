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
public class Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "source_id")
    private Long sourceId;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "privilege_channel", joinColumns = @JoinColumn(name = "privilege_id"), inverseJoinColumns = @JoinColumn(name = "channel_id"))
    private List<Channel> channels;

    @OneToMany(mappedBy = "privilege")
    private List<UserPrivilege> userPrivileges = new ArrayList<>();

}



