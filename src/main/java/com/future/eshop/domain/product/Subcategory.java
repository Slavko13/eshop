package com.future.eshop.domain.product;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "subcategory")
public class Subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer subcategoryID;

    private String title;

    @Type(type="text")
    private String description;

    private String code;

    @OneToMany(mappedBy = "subcategory")
    private List<Product> subcategories;






}
