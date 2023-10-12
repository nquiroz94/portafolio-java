package com.neqo.portafolio.domain.user.entities;

import com.neqo.portafolio.domain.profile.entities.Profile;
import com.neqo.portafolio.domain.user.vo.Login;

import java.util.List;

public class User {
    private String email;
    private String username;
    private String pwd;

    public User(String email, String username, String pwd) {
        this.email = email;
        this.username = username;
        this.pwd = pwd;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}


