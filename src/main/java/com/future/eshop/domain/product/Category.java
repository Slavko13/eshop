package com.future.eshop.domain.product;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer categoryID;

    private String title;

    @Type(type="text")
    private String description;

    private String code;

    @OneToMany()
    private List<Subcategory> subcategories;





}
