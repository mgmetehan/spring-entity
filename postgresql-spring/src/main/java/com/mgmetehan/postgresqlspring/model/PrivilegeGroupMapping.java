package com.mgmetehan.postgresqlspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "privilege_group_mapping")
@NoArgsConstructor
@AllArgsConstructor
public class PrivilegeGroupMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinTable(name = "privilegeGroupMapping_privilege", joinColumns = @JoinColumn(name = "privilege_group_mapping_id"), inverseJoinColumns = @JoinColumn(name = "privilege_id"))
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Privilege> privileges;

    @JoinTable(name = "privilegeGroupMapping_privilegegroup", joinColumns = @JoinColumn(name = "privilege_group_mapping_id"), inverseJoinColumns = @JoinColumn(name = "privilege_group_id"))
    @ManyToMany(fetch = FetchType.LAZY)
    private List<PrivilegeGroup> privilegeGroups;
}



