package org.amisescalade.controller;

import java.util.List;

import org.amisescalade.entity.User;
import org.amisescalade.entity.Topo;
import org.amisescalade.entity.TopoComment;

public interface ITopoCommentController {
	
	/**
	 * method adding a comment to topo
	 * 
	 * @param body
	 * @param author
	 * @param topo
	 * @return TopoComment object added
	 */
	public TopoComment addTopoComment(String body, User author, Topo topo);
	
	/**
	 * method to modify a topoComment
	 * 
	 * @param topoComment
	 * @return topoComment object modified
	 * @throws Exception
	 */
	public TopoComment editTopoComment (TopoComment topoComment);
	
	/**
	 * method for display a TopoComment by his id 
	 * 
	 * @param id
	 * @return TopoComment object to display
	 */
	public TopoComment displayTopoComment(Long id);
	
	/**
	 * method for display all comments from a topo
	 * 
	 * @param topo
	 * @return topoComment list for a topo
	 * @throws Exception
	 */
	public List<TopoComment> displayAllTopoCommentByTopo(Topo topo) throws Exception;

}
