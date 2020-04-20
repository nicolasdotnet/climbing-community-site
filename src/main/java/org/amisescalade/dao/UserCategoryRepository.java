package org.amisescalade.dao;

import java.util.List;

import org.amisescalade.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCategoryRepository extends JpaRepository<Role, Long>{

	Role findByRoleName(String userCategoryLabel);

	Role findByRoleNameIgnoreCase(String category);

	List<Role> findByRoleNameContainingIgnoreCase(String label);

}
