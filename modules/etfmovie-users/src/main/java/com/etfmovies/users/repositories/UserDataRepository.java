package com.etfmovies.users.repositories;

import com.etfmovies.users.models.UserData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserDataRepository extends CrudRepository<UserData, Long>{
    List<UserData> findAll();
}
