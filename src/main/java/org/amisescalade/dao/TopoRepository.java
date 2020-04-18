package org.amisescalade.dao;

import java.util.List;

import org.amisescalade.entity.Topo;
import org.amisescalade.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopoRepository extends JpaRepository<Topo, Long>{
	
	List<Topo> findByTopoTitleContainingIgnoreCase (String title);

    public List<Topo> findByTopoOwner(User topoOwner);

}
