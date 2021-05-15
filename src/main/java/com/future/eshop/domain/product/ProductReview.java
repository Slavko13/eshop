package com.future.eshop.domain.product;


import com.future.eshop.domain.user.EshopUser;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "product_review")
public class ProductReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer productReviewID;

    private String summary;

    @Column(name = "overall_rating")
    private byte overallRating;

    @Column(name = "product_styling")
    private byte productStyling;

    @Column(name = "product_quality")
    private byte productQuality;

    @Column(name = "product_durability")
    private byte productDurability;

    @Type(type="text")
    private String description;

    @JoinColumn(name = "user_id")
    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = EshopUser.class)
    private EshopUser eshopUser;

}
