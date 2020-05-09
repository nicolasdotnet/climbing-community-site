/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amisescalade.services.interfaces;

import java.util.List;
import org.amisescalade.entity.Country;

/**
 *
 * @author nicolasdotnet
 */
public interface ICountry {

    /**
     * method to get all country
     *
     * @return the country list
     */
    List<Country> getAllCountry();

}
