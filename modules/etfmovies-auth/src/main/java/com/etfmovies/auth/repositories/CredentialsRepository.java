package com.etfmovies.auth.repositories;

import com.etfmovies.auth.models.Credentials;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CredentialsRepository extends CrudRepository<Credentials, Long>{
    List<Credentials> findAll();
    Credentials findByUserName(String username);
}
