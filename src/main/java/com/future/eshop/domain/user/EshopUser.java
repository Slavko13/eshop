package com.future.eshop.domain.user;


import com.fasterxml.jackson.annotation.JsonView;
import com.future.eshop.domain.general.jsonViews.user.UserView;
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
    @JsonView(UserView.UserMainView.class)
    private UUID userID;

    @JsonView(UserView.UserMainView.class)
    private String username;

    @JsonView(UserView.UserFullView.class)
    private String password;

    @Column(name = "first_name")
    @JsonView(UserView.UserSoloView.class)
    private String firstName;

    @Column(name = "second_name")
    @JsonView(UserView.UserSoloView.class)
    private String secondName;

    @JsonView(UserView.UserMainView.class)
    private String email;

    @Column(name = "phone_number")
    @JsonView(UserView.UserSoloView.class)
    private String phoneNumber;

    @JoinColumn(name = "image_id")
    @JsonView(UserView.UserSoloView.class)
    @OneToOne(cascade = CascadeType.PERSIST, targetEntity = Image.class)
    private Image image;

    @OneToMany(mappedBy = "eshopUser", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JsonView(UserView.UserSoloView.class)
    private List<ProductReview> productReviews;

    @ManyToOne(targetEntity = Role.class, fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "role_id")
    @JsonView(UserView.UserFullView.class)
    private Role role;

    @Column(name = "user_status")
    @JsonView(UserView.UserFullView.class)
    @Enumerated(value = EnumType.STRING)
    private UserStatus userStatus;



}
