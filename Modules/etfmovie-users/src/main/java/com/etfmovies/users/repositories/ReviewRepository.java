package com.etfmovies.users.repositories;

import com.etfmovies.users.models.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {

}
