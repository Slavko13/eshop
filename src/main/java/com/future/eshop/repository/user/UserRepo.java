package com.future.eshop.repository.user;

import com.future.eshop.domain.user.EshopUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends CrudRepository<EshopUser, Integer> {

    Optional<EshopUser> findByUserName(String userName);
    Iterable<EshopUser> findAll();
    Iterable<EshopUser> findAllByRoleId(Integer roleID);




}
