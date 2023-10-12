package com.neqo.portafolio.infraestructure.user.models;


import jakarta.persistence.*;

@Entity
@Table(name = "ACCOUNTS")
public class AccountDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;
    private String username;
    private String email;


    public AccountDAO(String uuid, String username, String email) {
        this.uuid = uuid;
        this.username = username;
        this.email = email;
    }

    public AccountDAO() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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


}
