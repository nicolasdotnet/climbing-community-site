package org.amisescalade.dao;

import java.util.List;

import org.amisescalade.entity.UserCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCategoryRepository extends JpaRepository<UserCategory, Long>{

	UserCategory findByUserCategoryLabel(String userCategoryLabel);

	UserCategory findByUserCategoryLabelIgnoreCase(String category);

	List<UserCategory> findByUserCategoryLabelContainingIgnoreCase(String label);

}
