/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amisescalade.services;

import org.amisescalade.services.interfaces.ICountry;
import java.util.Arrays;
import java.util.List;
import org.amisescalade.entity.Country;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nicolasdotnet
 */
@Service
@Transactional
public class CountryImpl implements ICountry {

    @Override
    public List<Country> getAllCountry() {
        
        List<Country> c = Arrays.asList(Country.values());
        
        return Arrays.asList(Country.values());
    }

}
