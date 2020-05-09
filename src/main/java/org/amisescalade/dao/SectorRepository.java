package org.amisescalade.dao;

import java.util.List;

import org.amisescalade.entity.Sector;
import org.amisescalade.entity.Spot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectorRepository extends JpaRepository<Sector, Long> {

    List<Sector> findBySectorNameContainingIgnoreCase(String sectorName);

    List<Sector> findBySpot(Spot spot);

    Sector findBySectorName(String sectorName);

}
