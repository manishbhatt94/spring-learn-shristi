package com.productapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.productapp.model.entities.ApiUser;

@Repository
public interface IApiUserRepository extends JpaRepository<ApiUser, Integer> {

	@Query("SELECT au FROM ApiUser au JOIN FETCH au.roles WHERE au.username = ?1")
	Optional<ApiUser> findByUsername(String username);

}
