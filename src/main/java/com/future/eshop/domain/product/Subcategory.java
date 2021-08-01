package com.future.eshop.domain.product;


import com.fasterxml.jackson.annotation.JsonView;
import com.future.eshop.domain.general.jsonViews.product.SubcategoryView;
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
    @JsonView(SubcategoryView.SubcategoryMainView.class)
    private Integer subcategoryID;

    @JsonView(SubcategoryView.SubcategoryMainView.class)
    private String title;

    @Type(type="text")
    @JsonView(SubcategoryView.SubcategorySoloView.class)
    private String description;

    @JsonView(SubcategoryView.SubcategorySoloView.class)
    private String code;

    @OneToMany(mappedBy = "subcategory", cascade = CascadeType.ALL)
    @JsonView(SubcategoryView.SubcategoryMainView.class)
    private List<Product> products;


    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;


}
