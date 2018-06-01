package com.example.demo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import static com.example.demo.util.CommonUtils.passwordEncoder;

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
        setPassword(passwordEncoder.encode(plainPassword));
        setRole(role);
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
