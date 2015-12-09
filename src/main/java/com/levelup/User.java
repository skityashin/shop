package com.levelup;

import javax.persistence.*;

/**
 * Class {@link com.levelup.User}
 *
 * @author Skityashin Vladimir
 * @version 1.0
 * @since 09.12.15
 */
@Entity
@Table(name = "user")
@NamedQuery(name = "User.getALL", query = "select u from User u")

public class User {
    private long id;
    private String login;
    private String pass;
    private String email;

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "pass")
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
