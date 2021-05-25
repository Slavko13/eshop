package com.future.eshop.domain.product;

import com.future.eshop.domain.user.EshopUser;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "image")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer productID;

    private String title;

    @Type(type="text")
    private String description;

    private String code;

    private Integer price;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "product_rating")
    private Double productRating;

    @JoinColumn(name = "subcategory_id")
    @ManyToOne(targetEntity = Subcategory.class)
    private Subcategory subcategory;

    @JoinColumn(name = "brand_id")
    @ManyToOne(targetEntity = Brand.class)
    private Brand brand;

}
