package com.microfocus.demo.usermanager.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class UserMember implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;   // Unique ID of the user
    private String name;    // Username
    private String email;   // Email of the user
    private String userRole;    // Role/title of the position
    private String phone;   // Phone number
    private String imageUrl; // Profile image URL
    @Column(nullable = false, updatable = false)
    private String userSecret;

    public UserMember() {}

    public UserMember(String name, String email, String userRole, String phone, String imageUrl, String userSecret) {
        this.name = name;
        this.email = name;
        this.userRole = name;
        this.phone = name;
        this.imageUrl = name;
        this.userSecret = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserRole() {
        return this.userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String url) {
        this.imageUrl = url;
    }

    public String getUserSecret() {
        return this.userSecret;
    }

    public void setUserSecret(String secret) {
        this.userSecret = secret;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + "\'" +
                ", email='" + email + '\'' +
                ", userRole='" + userRole + '\'' +
                ", phone='" + phone + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

}

