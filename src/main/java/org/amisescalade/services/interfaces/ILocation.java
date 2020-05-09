/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amisescalade.services.interfaces;

import java.util.List;
import org.amisescalade.entity.Location;

/**
 *
 * @author nicolasdotnet
 */
public interface ILocation {
    
    	/**
	 * method to get all location
	 * 
	 * @return the location list
	 */
	List<Location> getAllLocation();
    
}
