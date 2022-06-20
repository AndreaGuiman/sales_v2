package com.gad.sales_v2.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gad.sales_v2.agent.Agent;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "user")
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String userRole;

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private Agent agent;

    public User() {
    }

    public User(String username, String password, String userRole) {
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    public User(Long id, String username, String password, String userRole) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    public Long getId() {
        return id;
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

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String agentRole) {
        this.userRole = agentRole;
    }

    public Agent getAgent() {
        return agent;
    }

    @Override
    public java.lang.String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userRole=" + userRole +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return username.equals(user.username) && password.equals(user.password) && userRole == user.userRole && agent.equals(user.agent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), username, password, userRole, agent);
    }
}
