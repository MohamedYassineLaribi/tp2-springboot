package com.isetn.laribi.laribi_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isetn.laribi.laribi_project.entities.AppRole;
import com.isetn.laribi.laribi_project.entities.AppUser;
import com.isetn.laribi.laribi_project.repos.RoleRepository;
import com.isetn.laribi.laribi_project.repos.UserRepository;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

    @Override
    public AppUser saveUser(AppUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public AppUser addRoleToUser(String username, String roleName) {
        AppUser usr = userRepository.findByUsername(username);
        AppRole r = roleRepository.findByRole(roleName);
        usr.getRoles().add(r);
        return usr;
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    @Override
    public void deleteAllRoles() {
        roleRepository.deleteAll();
    }

    @Override
    public AppRole addRole(AppRole role) {
        return roleRepository.save(role);
    }

    @Override
    public AppUser findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
