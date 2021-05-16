package com.future.eshop.service.user.role;

import com.future.eshop.domain.user.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();
    Role getRoleByName(String name);



}
