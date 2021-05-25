package com.future.eshop.repository.user;

import com.future.eshop.domain.user.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepo extends CrudRepository<Role, String> {

    Optional<Role> findByRoleName(String name);
}
