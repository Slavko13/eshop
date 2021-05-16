package com.future.eshop.domain.user;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Table(name = "user_role")
@AllArgsConstructor
@Entity
public class Role {

    public Role(String roleName) {
        this.roleName = roleName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "role_name")
    private String roleName;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ROLES_AUTHORITIES",
            joinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "AUTHORITIES_ID", referencedColumnName = "id")
    )
    @JsonManagedReference
    private List<Authority> authorities;

}
