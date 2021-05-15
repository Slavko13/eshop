package com.future.eshop.domain.user;


import com.future.eshop.domain.product.ProductReview;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@Table(name = "eshop_user")
@Entity
public class EshopUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer userID;

    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "eshopUser")
    private List<ProductReview> productReviews;

}
