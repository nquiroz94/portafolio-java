package com.neqo.portafolio.infraestructure.user.models;


import com.neqo.portafolio.infraestructure.profile.models.ProfileDAO;
import jakarta.persistence.*;

@Entity
@Table(name = "ACCOUNTS")
public class AccountDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;
    private String username;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    private ProfileDAO profile;


    public AccountDAO(String uuid, String username, String email, ProfileDAO profile) {
        this.uuid = uuid;
        this.username = username;
        this.email = email;
        this.profile = profile;
    }

    public AccountDAO() {
    }

    public ProfileDAO getProfile() {
        return profile;
    }

    public void setProfile(ProfileDAO profile) {
        this.profile = profile;
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

    @Override
    public String toString() {
        return "AccountDAO{" +
                "uuid='" + uuid + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", profile=" + profile +
                '}';
    }
}
