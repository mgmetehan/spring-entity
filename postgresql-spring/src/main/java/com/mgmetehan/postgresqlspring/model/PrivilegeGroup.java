package com.mgmetehan.postgresqlspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "privilege_group")
@NoArgsConstructor
@AllArgsConstructor
public class PrivilegeGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "privilegeGroups", fetch = FetchType.LAZY)
    private List<Account> accounts;

    @ManyToMany(mappedBy = "privilegeGroups", fetch = FetchType.LAZY)
    private List<PrivilegeGroupMapping> privilegeGroupMappings;
}



