package com.etfmovies.videoinfo.repositories;

import com.etfmovies.videoinfo.models.UserSession;
import org.springframework.data.repository.CrudRepository;

public interface UserSessionRepository extends CrudRepository<UserSession, Long> {
    public UserSession findByEmail(String email);
    public UserSession findByToken(String token);
}
