package com.microfocus.demo.usermanager;

import com.microfocus.demo.usermanager.model.UserMember;
import com.microfocus.demo.usermanager.service.UserMemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RestController
@RequestMapping("/user")
public class UserResource {
    private final UserMemberService userService;

    public UserResource(UserMemberService userService) {
        this.userService = userService;
    }

    // GET request for all our users
    @GetMapping("/all")
    public ResponseEntity<List<UserMember>> getAllUsers () {
        List<UserMember> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // GET request for specific user
    @GetMapping("/find/{id}")
    public ResponseEntity<UserMember> getUserById (@PathVariable("id") Long id) throws Throwable {
        UserMember user = userService.findUserById(id);
        return new ResponseEntity<UserMember>(user, HttpStatus.OK);
    }

    // POST request for adding new user
    @PostMapping("/add")
    public ResponseEntity<UserMember> addUser(@RequestBody UserMember user) {
            UserMember newUser = userService.addUserMember(user);
        return new ResponseEntity<UserMember>(newUser, HttpStatus.CREATED);
    }

    // POST request for updating user
    @PutMapping("/update")
    public ResponseEntity<UserMember> updateUser(@RequestBody UserMember user) {
        UserMember updateUser = userService.updateUser(user);
        return new ResponseEntity<UserMember>(updateUser, HttpStatus.OK);
    }

    // REMOVE request for updating user
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<UserMember>(HttpStatus.OK);
    }
}
