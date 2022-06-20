package com.gad.sales_v2.agent;

public class AgentDTO {
    private Long id;
    private String name;
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String username;
    private String password;

    public AgentDTO() {
    }

    public AgentDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public AgentDTO(String firstName, String lastName, String telephoneNumber, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
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

    @Override
    public String toString() {
        return "AgentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
