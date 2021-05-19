package com.future.eshop.service.user.auth;

import com.future.eshop.domain.user.EshopUser;
import com.future.eshop.domain.user.UserStatus;
import com.future.eshop.dto.user.UserDTO;
import com.future.eshop.repository.user.UserRepo;
import com.future.eshop.service.user.role.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class RegistrationServiceImpl implements RegistrationService {

   private final UserRepo userRepo;
   private final RoleService roleService;

    public RegistrationServiceImpl(UserRepo userRepo, RoleService roleService) {
        this.userRepo = userRepo;
        this.roleService = roleService;
    }

    @Override
    @Transactional
    public EshopUser addUser(UserDTO userDTO) {
        EshopUser eshopUser = new EshopUser();
        BeanUtils.copyProperties(userDTO, eshopUser);
        eshopUser.setUserID(UUID.randomUUID());
        eshopUser.setUserStatus(UserStatus.NOT_CONFIRMED);
        eshopUser.setRole(roleService.getRoleByName("ROLE_GUEST"));
        return userRepo.save(eshopUser);
    }
}
