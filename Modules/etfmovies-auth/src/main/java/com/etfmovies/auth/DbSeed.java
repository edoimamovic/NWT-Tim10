package com.etfmovies.auth;

import com.etfmovies.auth.models.Credentials;
import com.etfmovies.auth.repositories.CredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DbSeed {
    private CredentialsRepository credentialsRepository;

    @Autowired
    public DbSeed(CredentialsRepository credentialsRepository) {
        this.credentialsRepository = credentialsRepository;
    }

    @EventListener
    public void Seed(ContextRefreshedEvent event){
        seedRolesTable();
    }

    private void seedRolesTable(){
        List<Credentials> roles = credentialsRepository.findAll();

        if(roles == null || roles.size() <= 0){
            credentialsRepository.save(new Credentials("admin", "password", "test"));
        }
    }
}
