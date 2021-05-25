package com.future.eshop.service.user.auth;

import com.future.eshop.domain.user.EshopUser;
import com.future.eshop.dto.user.UserDTO;
import com.future.eshop.dto.user.UsernameSuggest;

import java.util.List;

public interface RegistrationService {

    EshopUser addUser(UserDTO userDTO);
    UsernameSuggest checkAndSuggestNewUsername(String email);
    String passwordSuggest();


}
