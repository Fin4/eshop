package rldev.eshop.entity;

import java.util.HashSet;
import java.util.Set;

//@Entity
//@Table(name = "CUSTOMERS", schema = "ESHOP")
public class Customer {

    private Long id;
    private String username;
    private String password;

    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;

    private Set<Order> orders;

    private Set<UserRole> roles = new HashSet<UserRole>(0);

    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name="id")

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    //@Column(name = "FIRSTNAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //@Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //@Column(name = "PHONE_NUMBER")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //@Column(name = "LASTNAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> userRoles) {
        this.roles = userRoles;
    }

    public Customer() {}

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", roles=" + roles +
                '}';
    }
}
