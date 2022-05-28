package com.mentorship.userservice.services;

import com.mentorship.userservice.entities.Role;
import com.mentorship.userservice.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
