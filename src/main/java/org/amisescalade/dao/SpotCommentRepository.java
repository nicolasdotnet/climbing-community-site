package org.amisescalade.dao;

import java.util.List;

import org.amisescalade.entity.Spot;
import org.amisescalade.entity.SpotComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpotCommentRepository extends JpaRepository<SpotComment, Long>{
	
	List<SpotComment> findBySpot(Spot spot);

}
