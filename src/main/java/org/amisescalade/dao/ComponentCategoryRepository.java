package org.amisescalade.dao;

import org.amisescalade.entity.ComponentCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentCategoryRepository extends JpaRepository<ComponentCategory, Long>{

	ComponentCategory findByLabelComponentCategory(String labelComponentCategory);

}
