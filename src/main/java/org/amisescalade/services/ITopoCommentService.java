package org.amisescalade.services;

import java.util.List;

import org.amisescalade.entity.Topo;
import org.amisescalade.entity.TopoComment;

public interface ITopoCommentService {
	
	/**
	 * method to register a topoComment
	 * 
	 * @param topoComment
	 * @return topoComment Object save
	 * @throws Exception
	 */
	TopoComment register(TopoComment topoComment) throws Exception;
	
	/**
	 * method to modify a topoComment
	 * 
	 * @param topoComment
	 * @return topoComment Object modify
	 * @throws Exception
	 */
	TopoComment edit(TopoComment topoComment) throws Exception;
	
	/**
	 * method to display one topoComment by his id
	 * 
	 * UTILE ?
	 * 
	 * @param topoComment
	 * @return topoComment Object to display
	 * @throws Exception
	 */
	TopoComment displayOne(Long id) throws Exception;
	
	/**
	 * method to display all topoComments
	 * 
	 * UTILE ?
	 * 
	 * @return the topoComment list 
	 */
	List<TopoComment> displayAll();
	
	/**
	 * method to display one topoComment by his topo
	 * 
	 * @param topo
	 * @return the topoComment list with his topo to display
	 * @throws Exception
	 */
	List<TopoComment> displayByTopo(Topo topo) throws Exception;

}
