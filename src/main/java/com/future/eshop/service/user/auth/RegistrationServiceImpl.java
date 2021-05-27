package com.future.eshop.service.user.auth;

import com.future.eshop.domain.user.EshopUser;
import com.future.eshop.domain.user.UserStatus;
import com.future.eshop.dto.user.UserDTO;
import com.future.eshop.dto.user.UsernameSuggest;
import com.future.eshop.exceptions.simpleException.TeapotException;
import com.future.eshop.repository.user.UserRepo;
import com.future.eshop.service.user.role.RoleService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RegistrationServiceImpl implements RegistrationService {

   private final UserRepo userRepo;
   private final RoleService roleService;
   private final BCryptPasswordEncoder passwordEncoder;

    public RegistrationServiceImpl(UserRepo userRepo, RoleService roleService, BCryptPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public EshopUser addUser(UserDTO userDTO) {
        if (userRepo.existsByUsername(userDTO.getUsername()) || userRepo.existsByEmail(userDTO.getEmail())) {
            throw new TeapotException("{RegistrationServiceImpl.addUser.exist}");
        }
        EshopUser eshopUser = new EshopUser();
        BeanUtils.copyProperties(userDTO, eshopUser);
        eshopUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        eshopUser.setUserID(UUID.randomUUID());
        eshopUser.setUserStatus(UserStatus.NOT_CONFIRMED);
        eshopUser.setRole(roleService.getRoleByName("ROLE_GUEST"));
        return userRepo.save(eshopUser);
    }

    @Override
    public UsernameSuggest checkAndSuggestNewUsername(String username) {


        Boolean userNameExist = userRepo.existsByUsername(username);
        if (!userNameExist) {
            return new UsernameSuggest(false);
        }
        List<String> usernamesSuggest = new ArrayList<>();

        for(int i = 0; i < 3; i++) {
            boolean suggestUsernameBoolean = true;
            while (suggestUsernameBoolean) {
                String numbers = RandomStringUtils.randomNumeric(2, 4);
                String specialChar = RandomStringUtils.random(2, 33, 47, false, false);
                String suggestUsername = username + numbers + specialChar;
                if (!userRepo.existsByUsername(suggestUsername)) {
                        usernamesSuggest.add(suggestUsername);
                        suggestUsernameBoolean = false;
                    }
                }
            }
        return UsernameSuggest.builder()
                .usernameExist(false)
                .freeUsernames(usernamesSuggest)
                .build();
    }

    @Override
    public String passwordSuggest() {
        String upperCaseLetters = RandomStringUtils.random(2, 65, 90, true, true);
        String lowerCaseLetters = RandomStringUtils.random(2, 97, 122, true, true);
        String numbers = RandomStringUtils.randomNumeric(2, 4);
        String specialChar = RandomStringUtils.random(2, 33, 47, false, false);
        String totalChars = RandomStringUtils.randomAlphanumeric(2);
        String combinedChars = upperCaseLetters.concat(lowerCaseLetters)
                .concat(numbers)
                .concat(specialChar)
                .concat(totalChars);
        List<Character> pwdChars = combinedChars.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        Collections.shuffle(pwdChars);
        return pwdChars.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}
