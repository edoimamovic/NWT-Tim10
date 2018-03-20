package com.etfmovies.users.repositories;

import com.etfmovies.users.models.ETFVideoUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ETFVideoUserRepository extends CrudRepository<ETFVideoUser, Long>{
    List<ETFVideoUser> findAll();
}
