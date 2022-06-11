package com.microfocus.demo.usermanager.service;

import com.microfocus.demo.usermanager.exceptions.UserNotFoundException;
import com.microfocus.demo.usermanager.model.UserMember;
import com.microfocus.demo.usermanager.repo.UserMemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.lang.annotation.Target;
import java.util.List;
import java.util.UUID;

@Component
public class UserMemberService {
    private final UserMemberRepo UserMemberRepo;

    // When service is constructed; build UserMemberRepo
    @Autowired
    public UserMemberService(com.microfocus.demo.usermanager.repo.UserMemberRepo userMemberRepo) {
        UserMemberRepo = userMemberRepo;
    }

    // Create & save a new user member
    public UserMember addUserMember(UserMember user) {
        user.setUserSecret(UUID.randomUUID().toString());
        return UserMemberRepo.save(user);
    }

    // Get all users
    public List<UserMember> findAllUsers() {
        return UserMemberRepo.findAll();
    }

    // Update target user
    public UserMember updateUser(UserMember user) {
        return UserMemberRepo.save(user);
    }

    // Find user by target ID
    public UserMember findUserById(Long id) throws Throwable {
        return UserMemberRepo.findUserById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    // Remove target user by ID
    public void deleteUser(Long id) {
        UserMemberRepo.deleteUserById(id);
    }
}
