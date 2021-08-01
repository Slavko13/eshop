package com.future.eshop.domain.product;

import com.fasterxml.jackson.annotation.JsonView;
import com.future.eshop.domain.general.jsonViews.product.ProductReviewView;
import com.future.eshop.domain.general.jsonViews.product.ProductView;
import com.future.eshop.domain.user.EshopUser;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonView(ProductView.ProductMainView.class)
    private Integer productID;

    @JsonView(ProductView.ProductMainView.class)
    private String title;

    @Type(type="text")
    @JsonView(ProductView.ProductSoloView.class)
    private String description;

    @JsonView(ProductView.ProductSoloView.class)
    private String code;

    @JsonView(ProductView.ProductMainView.class)
    private Integer price;

    @Column(name = "create_date")
    @JsonView(ProductView.ProductSoloView.class)
    private Date createDate;

    @Column(name = "product_rating")
    @JsonView(ProductView.ProductMainView.class)
    private Double productRating;

    @JoinColumn(name = "subcategory_id")
    @ManyToOne(targetEntity = Subcategory.class)
    @JsonView(ProductView.ProductFullView.class)
    private Subcategory subcategory;

    @JoinColumn(name = "brand_id")
    @ManyToOne(targetEntity = Brand.class)
    @JsonView(ProductView.ProductMainView.class)
    private Brand brand;


    @OneToMany(cascade = CascadeType.ALL, targetEntity = ProductReview.class, mappedBy = "product")
    @JsonView(ProductView.ProductSoloView.class)
    private List<ProductReview> productReviews;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = ProductComments.class, mappedBy = "product")
    @JsonView(ProductView.ProductSoloView.class)
    private List<ProductComments> productComments;


}
