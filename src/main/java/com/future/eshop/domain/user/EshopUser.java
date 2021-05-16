package com.future.eshop.domain.user;


import com.future.eshop.domain.image.Image;
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
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @JoinColumn(name = "image_id")
    @OneToOne(cascade = CascadeType.PERSIST, targetEntity = Image.class)
    private Image image;

    @OneToMany(mappedBy = "eshopUser")
    private List<ProductReview> productReviews;

    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = Role.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "user_status")
    @Enumerated(value = EnumType.STRING)
    private UserStatus userStatus;



}
