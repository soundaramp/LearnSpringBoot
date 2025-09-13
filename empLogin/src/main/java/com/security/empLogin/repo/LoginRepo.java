package com.security.empLogin.repo;

import com.security.empLogin.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepo extends JpaRepository<LoginEntity, Long> {
    public Optional<LoginEntity> findByUsername(String username);
}
