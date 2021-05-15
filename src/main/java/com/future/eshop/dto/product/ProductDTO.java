package com.future.eshop.dto.product;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import java.util.Date;

@Data
@NoArgsConstructor
@Builder
public class ProductDTO {

    private Integer productID;
    private String title;
    private String description;
    private String code;
    private Integer price;
    private Date createDate;
    private Double productRating;
    private Integer subCategoryID;

}
