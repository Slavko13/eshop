package com.future.eshop.domain.product;

import com.fasterxml.jackson.annotation.JsonView;
import com.future.eshop.domain.general.jsonViews.product.CategoryView;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonView(CategoryView.CategoryMainView.class)
    private Integer categoryID;

    @JsonView(CategoryView.CategoryMainView.class)
    private String title;

    @Type(type="text")
    @JsonView(CategoryView.CategorySoloView.class)
    private String description;

    @JsonView(CategoryView.CategorySoloView.class)
    private String code;

    @OneToMany(mappedBy = "category", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JsonView(CategoryView.CategoryMainView.class)
    private List<Subcategory> subcategories;





}
