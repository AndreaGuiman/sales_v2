package com.gad.sales_v2.user;

import java.util.Objects;

public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String userRole;

    public UserDTO() {
    }

    public UserDTO(Long id, String userRole) {
        this.id = id;
        this.userRole = userRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userRole=" + userRole +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return id.equals(userDTO.id) && username.equals(userDTO.username) && password.equals(userDTO.password) && userRole == userDTO.userRole;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, userRole);
    }
}
