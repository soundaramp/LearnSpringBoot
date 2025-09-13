package com.security.empLogin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

@Entity
public class LoginEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        String username;
        String password;
        String Role;

        public String getRole() {
                return Role;
        }

        public void setRole(String role) {
                Role = role;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getUsername() {
                return username;
        }

        public String getPassword() {
                return password;
        }
}
