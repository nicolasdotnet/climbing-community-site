/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amisescalade.services;

import org.amisescalade.services.interfaces.ILocation;
import java.util.Arrays;
import java.util.List;
import org.amisescalade.entity.Location;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nicolasdotnet
 */

@Service
@Transactional
public class LocationImpl implements ILocation{

    @Override
    public List<Location> getAllLocation() {
        
        List<Location> l = Arrays.asList(Location.values());
        
        return  Arrays.asList(Location.values());
        
        
    }
    
}
