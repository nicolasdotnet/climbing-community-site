package org.amisescalade.dao;

import java.util.List;

import org.amisescalade.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCategoryRepository extends JpaRepository<Role, Long>{

	Role findByUserCategoryLabel(String userCategoryLabel);

	Role findByUserCategoryLabelIgnoreCase(String category);

	List<Role> findByUserCategoryLabelContainingIgnoreCase(String label);

}
