package com.etfmovies.users.repositories;

import com.etfmovies.users.models.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RolesRepository extends CrudRepository<Role, Long> {
    List<Role> findAll();
    Role findByRoleName(String roleName);
}
