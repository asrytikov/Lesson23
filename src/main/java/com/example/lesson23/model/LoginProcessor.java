package com.example.lesson23.model;

import com.example.lesson23.services.LoggedUserManagementService;
import com.example.lesson23.services.LoginCountService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {

    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;
    private String username;
    private String password;

    public LoginProcessor(LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    public boolean login(){

        loginCountService.increment();

        String username = this.username;
        String password = this.password;

        boolean loginRes = false;
        if ("admin".equals(username) && "pass".equals(password)){
            loginRes = true;
            loggedUserManagementService.setUsername(username);
        }/*else {
            return false;
        }*/

        return loginRes;
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
}
