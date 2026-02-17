package com.productapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.productapp.model.entities.JwtUser;

@Repository
public interface IJwtUserRepository extends JpaRepository<JwtUser, Integer> {

	@Query("SELECT ju FROM JwtUser ju JOIN FETCH ju.roles WHERE ju.username = ?1")
	Optional<JwtUser> findByUsername(String username);

}
