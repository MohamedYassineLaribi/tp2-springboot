package com.isetn.laribi.laribi_project.entities;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.*;

@Entity
@Table(name = "app_user")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(unique = true)
    private String username;

    private String password;

    private Boolean enabled;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
        name = "app_user_role",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<AppRole> roles = new ArrayList<>();

    public AppUser() {}

    public AppUser(Long user_id, String username, String password, Boolean enabled, List<AppRole> roles) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles != null ? roles : new ArrayList<>();
    }

    public Long getUser_id() { return user_id; }
    public void setUser_id(Long user_id) { this.user_id = user_id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Boolean getEnabled() { return enabled; }
    public void setEnabled(Boolean enabled) { this.enabled = enabled; }

    public List<AppRole> getRoles() { return roles; }
    public void setRoles(List<AppRole> roles) { this.roles = roles; }
}
