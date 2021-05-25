package com.future.eshop.domain.product;


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
    private Integer brandID;

    @JoinColumn(name = "image_id")
    @OneToOne(targetEntity = Image.class)
    private Image image;

    @OneToMany(mappedBy = "brand", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Product> products;

    private String name;

    @Type(type = "text")
    private String description;



}
