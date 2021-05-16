package com.future.eshop.domain.general;

import com.future.eshop.domain.user.EshopUser;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data
public abstract class CommentBaseEntity {

    @JoinColumn(name = "user_id")
    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = EshopUser.class)
    private EshopUser eshopUser;

    private Integer rating;

    @Column(name = "public_date")
    private Date publicDate;

    @Column(name = "edit_date")
    private Date editDate;


}
