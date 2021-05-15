package com.future.eshop.dto.general;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageDTO {

    private Integer pageNumber;
    private Integer recordCount;

}
