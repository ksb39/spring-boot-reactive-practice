package com.example.demo.domain;

import com.example.demo.config.DefaultUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Document(collection = "user")
public class User extends BaseEntity {

    private String email;

    private String password;

    private Role role;

    public User(String email, String plainPassword, Role role) {
        setEmail(email);
        setPassword(DefaultUtil.passwordEncoder.encode(plainPassword));
        setRole(role);
    }

    public User(String email, String plainPassword, Role role, boolean deleted) {
        setEmail(email);
        setPassword(DefaultUtil.passwordEncoder.encode(plainPassword));
        setRole(role);
        setDelete(deleted);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", email='" + email.replaceFirst("@.*", "@***") +
                ", passwordHash='" + getPassword().substring(0, 10) +
                ", role=" + role +
                '}';
    }

}
