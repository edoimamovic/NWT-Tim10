package com.etfmovies.users.repositories;

import com.etfmovies.users.models.UserRoles;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRolesRepository extends CrudRepository<UserRoles, Long> {
    List<UserRoles> findAll();
    UserRoles findByRoleName(String roleName);
}
