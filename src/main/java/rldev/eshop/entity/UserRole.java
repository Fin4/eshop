package rldev.eshop.entity;

public class UserRole {

    private Long id;
    private String role;
    private Customer user;

    public Customer getUser() {
        return user;
    }

    public void setUser(Customer user) {
        this.user = user;
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

    public UserRole(Long id, String role, Customer user) {
        this.id = id;
        this.role = role;
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", role='" + role +
                '}';
    }
}
