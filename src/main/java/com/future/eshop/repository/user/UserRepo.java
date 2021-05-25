package com.future.eshop.repository.user;

import com.future.eshop.domain.user.EshopUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends CrudRepository<EshopUser, Integer> {

    Optional<EshopUser> findByUsername(String username);
    Iterable<EshopUser> findAll();
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);




}
