package com.future.eshop.domain.image;


import com.future.eshop.domain.general.base.entity.FileBaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "image")
public class Image extends FileBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer imageID;



}
