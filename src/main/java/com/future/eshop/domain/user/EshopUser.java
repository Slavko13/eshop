package com.future.eshop.domain.user;


import com.future.eshop.domain.image.Image;
import com.future.eshop.domain.product.ProductReview;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "eshop_user")
@Entity
@Builder
public class EshopUser {

    @Id
    @GenericGenerator(name = "id", strategy = "uuid2")
    @Column(name = "id")
    private UUID userID;

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

    @OneToMany(mappedBy = "eshopUser", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<ProductReview> productReviews;

    @ManyToOne(targetEntity = Role.class, fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "user_status")
    @Enumerated(value = EnumType.STRING)
    private UserStatus userStatus;



}
