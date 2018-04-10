package com.etfmovies.auth;

import com.etfmovies.auth.models.ApplicationUser;
import com.etfmovies.auth.repositories.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DbSeed {
    private ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public DbSeed(ApplicationUserRepository applicationUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @EventListener
    public void Seed(ContextRefreshedEvent event) {
        seedRolesTable();
    }

    private void seedRolesTable() {
        ApplicationUser usr = applicationUserRepository.findByUsername("admin");

        if (usr == null) {
            applicationUserRepository.save(new ApplicationUser("admin", bCryptPasswordEncoder.encode("password")));
        }
    }
}
