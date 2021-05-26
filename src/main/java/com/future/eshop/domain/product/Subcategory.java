package com.future.eshop.domain.product;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "subcategory")
@NoArgsConstructor
public class Subcategory {

    public Subcategory(Integer subcategoryID) {
        this.subcategoryID = subcategoryID;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer subcategoryID;

    private String title;

    @Type(type="text")
    private String description;

    private String code;

    @OneToMany(mappedBy = "subcategory", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Product> products;




}
