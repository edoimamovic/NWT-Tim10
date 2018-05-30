package com.etfmovies.users;

import com.etfmovies.users.models.Role;
import com.etfmovies.users.models.UserData;
import com.etfmovies.users.repositories.RolesRepository;
import com.etfmovies.users.repositories.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class DbSeed {
    private RolesRepository rolesRepository;
    private UserDataRepository userDataRepository;

    @Autowired
    public DbSeed(RolesRepository rolesRepository, UserDataRepository userDataRepository) {
        this.rolesRepository = rolesRepository;
        this.userDataRepository = userDataRepository;
    }

    @EventListener
    public void Seed(ContextRefreshedEvent event){
        seedRolesTable();
        seedUsersTable();
    }

    private void seedRolesTable(){
        List<Role> roles = rolesRepository.findAll();

        if(roles == null || roles.size() <= 0){
            rolesRepository.save(new Role("Guest", "Test Description"));
            rolesRepository.save(new Role("RegisteredUser", "Test Description"));
            rolesRepository.save(new Role("TestRole1", "Test Description"));
        }
    }

    private void seedUsersTable(){
        List<UserData> userData = userDataRepository.findAll();

        if(userData == null || userData.size() <= 0){
            Role guestUserRole = rolesRepository.findByRoleName("Guest");
            Role registeredUserRole = rolesRepository.findByRoleName("RegisteredUser");

            userDataRepository.save(new UserData("Admin", "LastName", new Date(1995,2,2), "admin@example.com" ,"guestuser", guestUserRole.getId()));
            userDataRepository.save(new UserData("john2", "doe2", new Date(1995,2,2), "test2@email.com" ,"admin", registeredUserRole.getId()));
            userDataRepository.save(new UserData("john3", "doe2", new Date(1995,2,2), "test2@email.com" ,"admin", registeredUserRole.getId()));
        }
    }
}
