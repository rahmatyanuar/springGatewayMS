package com.rahmat.gateway.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahmat.gateway.model.Role;
import com.rahmat.gateway.model.enumeration.ERole;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Optional<Role> findByName(ERole name);
	List<Role> findAll();
}
