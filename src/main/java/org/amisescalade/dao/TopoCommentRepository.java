package org.amisescalade.dao;

import java.util.List;

import org.amisescalade.entity.Topo;
import org.amisescalade.entity.TopoComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopoCommentRepository extends JpaRepository<TopoComment, Long> {
	
	List<TopoComment> findByTopo(Topo topo);


}
