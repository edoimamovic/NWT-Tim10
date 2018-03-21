package com.etfmovies.videoinfo.repositories;

import com.etfmovies.videoinfo.models.Category;
import com.etfmovies.videoinfo.models.Film;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();
}
