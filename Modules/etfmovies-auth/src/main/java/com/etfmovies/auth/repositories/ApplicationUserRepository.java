package com.etfmovies.auth.repositories;


import com.etfmovies.auth.models.ApplicationUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ApplicationUserRepository extends CrudRepository<ApplicationUser, Long>{
    ApplicationUser findByUsername(String username);
}
