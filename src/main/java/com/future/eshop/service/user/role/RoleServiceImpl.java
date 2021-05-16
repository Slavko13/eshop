package com.future.eshop.service.user.role;

import com.future.eshop.domain.user.Role;
import com.future.eshop.exceptions.simpleException.NotFoundException;
import com.future.eshop.repository.user.RoleRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepo roleRepo;

    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }


    @Override
    @Transactional
    public List<Role> getAllRoles() {
        return null;
    }

    @Override
    @Transactional
    public Role getRoleByName(String name) {
        return roleRepo.findByRoleName(name).orElseThrow(()-> new NotFoundException("{RoleServiceImpl.getRoleByName.NotFound}"));
    }
}
