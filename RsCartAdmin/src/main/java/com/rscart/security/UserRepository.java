package com.rscart.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rscart.entities.User;

/**
 * @author Raviteja Bollimuntha
 *
 */
public interface UserRepository extends JpaRepository<User, Integer>
{

	User findByEmail(String email);

}
