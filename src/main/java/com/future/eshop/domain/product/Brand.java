package com.future.eshop.domain.product;


import com.fasterxml.jackson.annotation.JsonView;
import com.future.eshop.domain.general.jsonViews.product.BrandView;
import com.future.eshop.domain.image.Image;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonView(BrandView.BrandMainView.class)
    private Integer brandID;

    @JoinColumn(name = "image_id")
    @OneToOne(targetEntity = Image.class)
    @JsonView(BrandView.BrandMainView.class)
    private Image image;

    @OneToMany(mappedBy = "brand", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JsonView(BrandView.BrandSoloView.class)
    private List<Product> products;

    @JsonView(BrandView.BrandMainView.class)
    private String name;

    @Type(type = "text")
    @JsonView(BrandView.BrandSoloView.class)
    private String description;



}
