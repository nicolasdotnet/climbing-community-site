package org.amisescalade.dao;

import java.util.List;

import org.amisescalade.entity.ComponentCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentCategoryRepository extends JpaRepository<ComponentCategory, Long> {

    List<ComponentCategory> findByComponentCategoryLabelContainingIgnoreCase(String label);

    ComponentCategory findByComponentCategoryLabel(String componentCategoryLabel);

}
