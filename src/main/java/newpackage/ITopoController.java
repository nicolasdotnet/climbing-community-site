package org.amisescalade.controller;

import java.util.List;

import org.amisescalade.entity.User;
import org.amisescalade.entity.Topo;

public interface ITopoController {
	
	/**
	 * method for adding a user topo
	 * 
	 * @param topoArea
	 * @param topoTitle
	 * @param topoDescription
	 * @param topoOwner
	 * @return topo object save
	 */
	public Topo addTopo(String topoArea, String topoTitle, String topoDescription,User topoOwner);
	
	/**
	 * method to modify a topo
	 * 
	 * @param topo
	 * @return topo object modified
	 */
	public Topo editTopo(Topo topo);
	
	/**
	 * method to display one topo by his id
	 * 
	 * @param id
	 * @return topo object to display
	 */
	public Topo displayTopo(Long id);
	
	/**
	 * method to display all topos
	 * 
	 * @return the topos list 
	 */
	public List<Topo> displayAllTopos();
	
	
	/**
	 * method to display a topo by his title
	 * 
	 * @param topoTitle
	 * @return the topo list 
	 */
	public List<Topo> displayTopoByTitle(String topoTitle);
	
	

}
