package com.neqo.portafolio.infraestructure.user.models;

import jakarta.persistence.*;

@Entity
@Table(name = "PASSWORDS")
public class PasswordDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;
    private String account_uuid;
    private String password;
    private String salt;
    private Boolean active;
    private Integer login_attempts;

    public PasswordDAO(String uuid, String account_uuid, String password, String salt, Boolean active) {
        this.uuid = uuid;
        this.account_uuid = account_uuid;
        this.password = password;
        this.salt = salt;
        this.active = active;
    }

    public PasswordDAO() {

    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAccount_uuid() {
        return account_uuid;
    }

    public void setAccount_uuid(String account_uuid) {
        this.account_uuid = account_uuid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
