package org.amisescalade.dao;

import java.util.List;

import org.amisescalade.entity.Spot;
import org.amisescalade.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SpotRepository extends JpaRepository<Spot, Long> {

    List<Spot> findBySpotNameContainingIgnoreCase(String spotname);

    Spot findBySpotName(String spotName);

    List<Spot> findAllBySpotAuthor(User spotAuthor);

    @Query("select s "
            + "from Spot s "
            + "where (:spotName is null or s.spotName like %:spotName% )"
            + "and (:spotRate is null or s.spotRate = :spotRate )"
            + "and (:location is null or s.location like %:location%) "
            + "and (:sectorCount is null or s.sectorCount = :sectorCount) ")
    List<Spot> findAllSpotsByMc(
            @Param("spotName") String spotName,
            @Param("spotRate") String spotRate,
            @Param("location") String location,
            @Param("sectorCount") String sectorCount);
}
