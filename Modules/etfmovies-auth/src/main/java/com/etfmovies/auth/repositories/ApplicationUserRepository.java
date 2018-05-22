package com.etfmovies.auth.repositories;


import com.etfmovies.auth.models.ApplicationUser;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationUserRepository extends CrudRepository<ApplicationUser, Long> {
    ApplicationUser findByEmail(String email);
}
