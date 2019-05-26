/**
 * 
 */
package com.rscart.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rscart.entities.Permission;

/**
 * @author Raviteja Bollimuntha
 *
 */
public interface PermissionRepository extends JpaRepository<Permission, Integer>
{

}
