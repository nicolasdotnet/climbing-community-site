package org.amisescalade.dao;

import java.util.List;

import org.amisescalade.entity.Sector;
import org.amisescalade.entity.SectorComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectorCommentRepository extends JpaRepository<SectorComment, Long>{
	
	List<SectorComment> findBySector(Sector sector);

}
