package com.etfmovies.users.repositories;

import com.etfmovies.users.models.PersonalData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonalDataRepository extends CrudRepository<PersonalData, Long> {
    List<PersonalData> findAll();
    PersonalData findByEmail(String email);
}
