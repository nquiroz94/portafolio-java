package com.neqo.portafolio.domain.user.vo;

public class Login {
    private String username;
    private String password;
    private String encrypt_key; //TODO: esto es parte del model. debes moverlo.

    public Login(String username, String password, String encrypt_key) {
        this.username = username;
        this.password = password;
        this.encrypt_key = encrypt_key;
    }

    public Login() {
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

    public String getEncrypt_key() {
        return encrypt_key;
    }

    public void setEncrypt_key(String encrypt_key) {
        this.encrypt_key = encrypt_key;
    }
}
