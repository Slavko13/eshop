package com.future.eshop.domain.user;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer authorityID;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "authorities")
    private List<Role> roles;



}
