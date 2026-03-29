package com.auction.client.model;

import com.auction.client.model.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String id;
    private String username;
    private String password;
    private String email;

    private String fullname;
    private Role role;
    private boolean active;

    public User(String id, String username, String password, String email, String fullname, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullname = fullname;
        this.role = role;
        this.active = true;
    }

    // Getter - Setter
    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getFullname() {return fullname;}
    public void setFullname(String fullname) {this.fullname = fullname;}

    public Role getRole() {return role;}
    public void setRole(Role role) {this.role = role;}

    public boolean isActive() {return active;}
    public void setActive(boolean active) {this.active = active;}

    // helper methods
    public boolean isBidder() {return role.canBid();}
    public boolean isSeller() {return role.canSell();}
    public boolean isAdmin() {return role.isAdmin();}

    // Override methods
    @Override
    public String toString() {
        return "User{id='" + id + "', username='" + username + "', role=" + role + "}";
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof User other)) return false;
        return  id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
