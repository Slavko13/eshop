package com.future.eshop.domain.user;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.future.eshop.domain.general.jsonViews.user.AuthorityView;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonView(AuthorityView.AuthorityMainView.class)
    private Integer authorityID;

    @JsonView(AuthorityView.AuthorityMainView.class)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "authorities")
    private List<Role> roles;



}
