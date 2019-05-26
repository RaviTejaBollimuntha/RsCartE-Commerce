package com.rscart.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rscart.entities.Role;

/**
 * @author Raviteja Bollimuntha
 *
 */
public interface RoleRepository extends JpaRepository<Role, Integer>
{

	Role findByName(String name);

}
