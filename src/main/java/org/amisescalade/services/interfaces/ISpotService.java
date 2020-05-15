package org.amisescalade.services.interfaces;

import java.util.List;

import org.amisescalade.entity.Spot;
import org.springframework.data.domain.Page;

public interface ISpotService {

    /**
     * method to register a spot
     *
     * @param spotName
     * @param spotRate
     * @param spotDescription
     * @param spotAccessPath
     * @param location
     * @param country
     * @param username
     * @return spot object saved
     * @throws Exception
     */
    Spot register(String spotName, String spotRate, String spotDescription, String spotAccessPath, String location, String country, String username) throws Exception;

    /**
     * method to modify a spot
     *
     * @param spot
     * @return spot object modified
     * @throws Exception
     */
    Spot edit(Spot spot) throws Exception;

    Spot modifyStatus(Long id) throws Exception;

    /**
     * method to get a spot by his id
     *
     * @param id
     * @return spot object
     * @throws Exception
     */
    Spot getSpot(Long id) throws Exception;

    /**
     * method to get all spots
     *
     * @param p for number page
     * @param s for size page
     * @return the spot page
     */
    Page<Spot> getAllSpots(int p, int s);

    /**
     * method to get all spots by his name
     *
     * @param spotname
     * @return the spot list by his title
     * @throws Exception
     */
    List<Spot> getAllSpotsByName(String spotname) throws Exception;

    /**
     * method to remove a spot
     *
     * @param spotId
     * @throws Exception
     */
    void delete(Long spotId) throws Exception;

    /**
     * method to get a spot by his author
     *
     * @param username
     * @return
     * @throws Exception
     */
    public List<Spot> getAllSpotsByAuthor(String username) throws Exception;

    /**
     * method to get all spots by MC
     *
     * @param spotName
     * @param spotRate
     * @param location
     * @param sectorCount
     * @return the spot list by MC
     */
    List<Spot> getAllSpotsByMc(String spotName, String spotRate, String location, String sectorCount);

}
