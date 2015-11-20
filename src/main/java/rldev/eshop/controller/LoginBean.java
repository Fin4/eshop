package rldev.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@Component
@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean implements Serializable {

    private String username = null;
    private String password = null;

    //@ManagedProperty("#{authenticationManager}")
    @Autowired
    private transient AuthenticationManager authenticationManager = null;

    public String login() {
        try{
            Authentication request = new UsernamePasswordAuthenticationToken(this.getUsername(), this.getPassword());
            Authentication result = authenticationManager.authenticate(request);
            SecurityContextHolder.getContext().setAuthentication(result);

        } catch (AuthenticationException e) {

            e.printStackTrace();
            return "incorrect";
        }
        return "correct";
    }

    public String logout() {
        SecurityContextHolder.clearContext();
        return "loggedout";
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

    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

}