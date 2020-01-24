package org.amisescalade.dao;

import org.amisescalade.entity.UserCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCategoryRepository extends JpaRepository<UserCategory, Long>{

	UserCategory findByUserCategoryLabel(String userCategoryLabel);

}
