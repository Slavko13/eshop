package com.future.eshop.domain.product;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.future.eshop.domain.general.jsonViews.product.ProductReviewView;
import com.future.eshop.domain.user.EshopUser;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product_review")
public class ProductReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonView(ProductReviewView.ProductReviewMainView.class)
    private Integer productReviewID;

    @JsonView(ProductReviewView.ProductReviewMainView.class)
    private String summary;

    @JsonView(ProductReviewView.ProductReviewSoloView.class)
    @Column(name = "overall_rating")
    private byte overallRating;

    @JsonView(ProductReviewView.ProductReviewSoloView.class)
    @Column(name = "product_styling")
    private byte productStyling;

    @JsonView(ProductReviewView.ProductReviewSoloView.class)
    @Column(name = "product_quality")
    private byte productQuality;

    @JsonView(ProductReviewView.ProductReviewSoloView.class)
    @Column(name = "product_durability")
    private byte productDurability;

    @Type(type="text")
    @JsonView(ProductReviewView.ProductReviewSoloView.class)
    private String description;

    @JoinColumn(name = "user_id")
    @JsonView(ProductReviewView.ProductReviewSoloView.class)
    @ManyToOne(targetEntity = EshopUser.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private EshopUser eshopUser;

    @JoinColumn(name = "product_id")
    @ManyToOne(targetEntity = Product.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    private Product product;

}
