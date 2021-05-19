package com.future.eshop.service.user.auth;

import com.future.eshop.domain.user.EshopUser;
import com.future.eshop.dto.user.UserDTO;

public interface RegistrationService {

    EshopUser addUser(UserDTO userDTO);


}
