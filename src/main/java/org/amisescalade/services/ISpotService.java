package org.amisescalade.services;

import java.util.List;

import org.amisescalade.entity.Spot;

public interface ISpotService {

    /**
     * method to register a sp
     *
     * @param spotName
     * @param spotRate
     * @param spotDescription
     * @param spotAccessPath
     * @param departement
     * @param country
     * @return spot object saved
     * @throws Exception
     */
    Spot register(String spotName, String spotRate, String spotDescription, String spotAccessPath, String departement, String country) throws Exception;

    /**
     * method to modify a spot
     *
     * @param spot
     * @return spot object modified
     * @throws Exception
     */
    Spot edit(Spot spot) throws Exception;

    /**
     * method to get a spot by his id
     *
     * @param spot
     * @return spot object
     * @throws Exception
     */
    Spot getSpot(Long id) throws Exception;

    /**
     * method to get all spots
     *
     * @return the spot list
     */
    List<Spot> getAllSpots();

    /**
     * method to get all spots by his name
     *
     * @param spotname
     * @return the spot list with his title
     * @throws Exception
     */
    List<Spot> getAllSpotsByName(String spotname) throws Exception;

    void delete(Long id);

    List<Spot> getAllSpotsByNameRateDepartement(String spotName, String spotRate, String departement);

}
