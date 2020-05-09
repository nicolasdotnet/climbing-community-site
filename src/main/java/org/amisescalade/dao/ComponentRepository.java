package org.amisescalade.dao;

import java.util.List;

import org.amisescalade.entity.ComponentCategory;
import org.amisescalade.entity.Sector;
import org.amisescalade.entity.Component;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentRepository extends JpaRepository<Component, Long> {

    List<Component> findByComponentNameContainingIgnoreCase(String componentName);

    List<Component> findByComponentCategory(ComponentCategory componentCategory);

    List<Component> findBySector(Sector sector);

    Component findByComponentCode(String componentCode);

}
