package org.amisescalade.dao;

import java.util.List;

import org.amisescalade.entity.Spot;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SpotRepository extends JpaRepository<Spot, Long> {

    List<Spot> findBySpotNameContainingIgnoreCase(String spotname);
    
    Spot findBySpotName(String spotName);

//    @Query("select spot "
//            + "from Spot spot "
//            + "where spot.spotRate =:spotRate and spot.departement =:departement")
//  List<Spot> findByOfficialNotNullAndSpotRateNotNullAndDepartementNotNullAllIgnoreCase(@Param("spotRate")String spotRate, @Param("departement")String departement);

    List<Spot> findBySpotRateAndDepartementAndSectorCountAllIgnoreCase(String spotRate, String departement, String sectorCount);  
    
}
