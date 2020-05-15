/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amisescalade.services.interfaces;

import java.util.List;
import org.amisescalade.entity.Pitch;
import org.amisescalade.entity.Component;

public interface IPitchService {

    /**
     * method to register a pitch
     *
     * @param pitchCode
     * @param pitchHeight
     * @param pitchRate
     * @param componentId
     * @param username
     * @return Pitch object saved
     * @throws Exception
     */
    Pitch register(String pitchCode, String pitchHeight, String pitchRate, Long componentId, String username) throws Exception;

    /**
     * method to modify a Pitch
     *
     * @param Pitch
     * @return Pitch object modified
     * @throws Exception
     */
    Pitch edit(Pitch Pitch) throws Exception;

    /**
     * method to get a Pitch by his id
     *
     * @param pitchId
     * @return Pitch object
     * @throws Exception
     */
    Pitch getPitch(Long pitchId) throws Exception;

    /**
     * method to get all Pitchs
     *
     * @return the componentPitch list
     */
    List<Pitch> getAllPitch();

    /**
     * method to get all Pitchs by his component
     *
     * @param component
     * @return the Pitch list with his component
     * @throws Exception
     */
    List<Pitch> getAllPitchsByComponent(Component component) throws Exception;

    /**
     * method to remove a pitch
     *
     * @param pitchId
     * @throws Exception
     */
    public void delete(Long pitchId) throws Exception;

}
