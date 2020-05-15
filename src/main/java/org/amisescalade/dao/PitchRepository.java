/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amisescalade.dao;

import java.util.List;
import org.amisescalade.entity.Component;
import org.amisescalade.entity.Pitch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PitchRepository extends JpaRepository<Pitch, Long> {

    List<Pitch> findByComponent(Component component);

}
