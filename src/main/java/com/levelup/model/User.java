package com.levelup.model;

import javax.persistence.*;

/**
 * Class {@link User}
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
    private Role role;

    public User() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Column(name = "login", nullable = false, length = 50)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    @Column(name = "pass", nullable = false)
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


    @Enumerated(EnumType.STRING)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
