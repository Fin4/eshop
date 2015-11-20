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

import java.util.HashSet;
import java.util.Set;

@Service("customerDetailsService")
//@Transactional(readOnly = true)
public class CustomerDetailsService implements UserDetailsService {

    @Autowired
    private CustomerDAO customerDAO;


    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Customer customer = customerDAO.findByUsername(s);

        //Set<UserRole> roles = new HashSet<UserRole>(customerDAO.getRolesByUsername(s));

        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        /*for (UserRole role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }*/

        return new User(
                customer.getUsername(),
                customer.getPassword(),
                //"LizardKing",
                //"jim",
                true,
                true,
                true,
                true,
                authorities);
    }
}
