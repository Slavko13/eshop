package com.future.eshop.domain.user;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.future.eshop.domain.general.jsonViews.user.RoleView;
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
    @Column(name = "role_name")
    @JsonView(RoleView.RoleMainView.class)
    private String roleName;


    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "ROLES_AUTHORITIES",
            joinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "role_name"),
            inverseJoinColumns = @JoinColumn(name = "AUTHORITIES_ID", referencedColumnName = "id")
    )
    @JsonManagedReference
    @JsonView(RoleView.RoleFullView.class)
    private List<Authority> authorities;

}
