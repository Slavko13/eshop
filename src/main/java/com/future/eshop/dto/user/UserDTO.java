package com.future.eshop.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;


@Data
@NoArgsConstructor
public class UserDTO {

    private String username;
    private String password;
    private String firstName;
    private String secondName;
    private String email;
    private String phoneNumber;


}
