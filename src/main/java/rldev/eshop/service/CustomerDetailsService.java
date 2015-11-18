package rldev.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rldev.eshop.dao.CustomerDAO;
import rldev.eshop.entity.Customer;
import rldev.eshop.entity.UserRole;

import javax.faces.bean.ManagedProperty;
import java.util.HashSet;
import java.util.Set;

@Service("customerDetailsService")
public class CustomerDetailsService implements UserDetailsService {

    @Autowired
    private CustomerDAO customerDAO;

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Customer customer = customerDAO.findByUsername(s);

        Set<UserRole> roles = customer.getRoles();

        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

        for (UserRole role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }

        return new User(customer.getUsername(),
                customer.getPassword(),
                true,
                true,
                true,
                true,
                authorities);
    }
}
