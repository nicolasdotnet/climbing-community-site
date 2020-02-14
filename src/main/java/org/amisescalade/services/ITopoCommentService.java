package org.amisescalade.services;

import java.util.List;

import org.amisescalade.entity.Topo;
import org.amisescalade.entity.TopoComment;
import org.amisescalade.entity.User;

public interface ITopoCommentService {
	
	/**
	 * method to register a topoComment
	 * 
	 * @param body
	 * @param author
	 * @param topo
	 * @return topoComment object saved
	 * @throws Exception
	 */
	TopoComment register(String body, User author, Topo topo) throws Exception;
	
	/**
	 * method to modify a topoComment
	 * 
	 * @param topoComment
	 * @return topoComment object modified
	 * @throws Exception
	 */
	TopoComment edit(TopoComment topoComment) throws Exception;
	
	/**
	 * method to get a topoComment by his id
	 * 
	 * UTILE ?
	 * 
	 * @param topoComment
	 * @return topoComment object
	 * @throws Exception
	 */
	TopoComment getTopoComment(Long id) throws Exception;
	
	/**
	 * method to get all topoComments
	 * 
	 * UTILE ?
	 * 
	 * @return the topoComment list 
	 */
	List<TopoComment> getAllTopoCommentS();
	
	/**
	 * method to get all topoComments by his topo
	 * 
	 * @param topo
	 * @return the topoComment list with his topo
	 * @throws Exception
	 */
	List<TopoComment> getAllTopoCommentsByTopo(Topo topo) throws Exception;

}
