package com.future.eshop.repository.user;

import com.future.eshop.domain.user.EshopUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<EshopUser, Integer> {




}
