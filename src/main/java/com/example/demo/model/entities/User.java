package com.example.demo.model.entities;

import com.example.demo.model.enums.Role;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@DynamicUpdate
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    Long id;

    @Column(columnDefinition = "TEXT")
    String email;

    @Column(columnDefinition = "TEXT")
    String name;

    @Column(columnDefinition = "TEXT")
    String passwordHash;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Long getId() {
        return id;
    }

    public void setEmail(String username) {
        this.email = username;
    }

    public void setPassword(String password) {
        setPasswordHash(DigestUtils.sha1Hex(password.trim()));
    }

    public boolean checkPassword(String password) {
        return getPasswordHash().equals(DigestUtils.sha1Hex(password.trim()));
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(email, user.email) && Objects.equals(passwordHash, user.passwordHash) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, passwordHash, role);
    }
}
