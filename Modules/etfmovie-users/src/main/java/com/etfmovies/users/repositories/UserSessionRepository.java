package com.etfmovies.users.repositories;

import com.etfmovies.users.models.UserSession;
import org.springframework.data.repository.CrudRepository;

public interface UserSessionRepository extends CrudRepository<UserSession, Long> {
    public UserSession findByEmail(String email);
    public UserSession findByToken(String token);
}
