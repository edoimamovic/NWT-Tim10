package com.etfmovies.users.repositories;

import com.etfmovies.users.models.Favourite;
import org.springframework.data.repository.CrudRepository;

public interface FavouritesRepository extends CrudRepository<Favourite, Long> {

}
