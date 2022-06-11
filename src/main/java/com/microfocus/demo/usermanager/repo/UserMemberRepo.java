package com.microfocus.demo.usermanager.repo;

import com.microfocus.demo.usermanager.model.UserMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserMemberRepo extends JpaRepository<UserMember, Long> {
    void deleteUserById(Long id);

    Optional<UserMember> findUserById(Long id);
}
