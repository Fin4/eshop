package rldev.eshop.entity;

public class UserRole {

    private Long id;
    private String role;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserRole() {
    }

    public UserRole(Long id, String role, String username) {
        this.id = id;
        this.role = role;
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
