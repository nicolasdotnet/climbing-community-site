package org.amisescalade.services;

import java.util.List;

import org.amisescalade.entity.Topo;
import org.amisescalade.entity.User;

public interface ITopoService {
	
	/**
	 * method to register a topo
	 * 
	 * @param topoArea
	 * @param topoTitle
	 * @param topoDescription
	 * @param topoOwner
	 * @return topo object saved
	 * @throws Exception
	 */
	Topo register (String topoArea, String topoTitle, String topoDescription, User topoOwner) throws Exception;
	
	/**
	 * method to modify a topo
	 * 
	 * @param topo
	 * @return topo object modified
	 * @throws Exception
	 */
	Topo edit(Topo topo) throws Exception;
	
	/**
	 * method to get a topo by his id
	 * 
	 * @param topo
	 * @return topo object
	 * @throws Exception
	 */
	Topo getTopo(Long id) throws Exception;
	
	/**
	 * method to get all topos
	 * 
	 * @return the topo list 
	 */
	List<Topo> getAllTopos();
	
	
	/**
	 * method to get a topo by his title
	 * 
	 * @param topo
	 * @return the topo list with his title
	 * @throws Exception
	 */
	List<Topo> getTopoByTitle(String title) throws Exception;
	
	
	
	

}
