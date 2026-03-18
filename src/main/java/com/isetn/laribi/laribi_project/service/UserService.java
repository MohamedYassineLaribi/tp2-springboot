package com.isetn.laribi.laribi_project.service;

import com.isetn.laribi.laribi_project.entities.AppRole;
import com.isetn.laribi.laribi_project.entities.AppUser;

public interface UserService {
    void deleteAllUsers();
    void deleteAllRoles();
    AppUser saveUser(AppUser user);
    AppUser findUserByUsername(String username);
    AppRole addRole(AppRole role);
    AppUser addRoleToUser(String username, String roleName);
}
