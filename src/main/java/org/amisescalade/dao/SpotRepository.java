package org.amisescalade.dao;

import java.util.List;

import org.amisescalade.entity.Spot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpotRepository extends JpaRepository<Spot, Long> {

    List<Spot> findBySpotNameContainingIgnoreCase(String spotname);

//    List<Spot> findAllBySpotNameContainingNotNullAndSpotRateNotNullAndDepartementNotNullAllIgnoreCase(String spotName, String spotRate, String departement);

}
