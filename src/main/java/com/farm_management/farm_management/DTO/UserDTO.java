package com.farm_management.farm_management.DTO;

import com.farm_management.farm_management.entity.Role;

public class UserDTO {
    private int id;          // Unique identifier for the user
    private String username;  // Username for the user
    private String email;     // Email of the user
    private Role role;      // Role of the user (e.g., FARMER, WORKER, ADMIN)
    private Boolean enabled;  // Indicates if the user account is active or not

    public UserDTO() {
    }

    public UserDTO(int id, String username, String email, Role role, Boolean enabled) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", enabled=" + enabled +
                '}';
    }
}
