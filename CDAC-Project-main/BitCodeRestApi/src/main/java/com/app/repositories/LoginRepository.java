package com.app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {
	Optional<Login> findByUsername(String username);
}
