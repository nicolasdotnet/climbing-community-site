package org.amisescalade.services.interfaces;

import java.util.List;

import org.amisescalade.entity.ComponentCategory;
import org.amisescalade.entity.Sector;
import org.amisescalade.entity.Component;

public interface IComponentService {

    /**
     * method to register a component
     *
     * @param componentCode
     * @param componentName
     * @param componentRate
     * @param componentDescription
     * @param componentCategoryId
     * @param sectorId
     * @param username
     * @return sectorComponent object saved
     * @throws Exception
     */
    Component register(String componentCode, String componentName, String componentRate, String componentDescription, Long componentCategoryId, Long sectorId, String username) throws Exception;

    /**
     * method to modify a component
     *
     * @param component
     * @return sectorComponent object modified
     * @throws Exception
     */
    Component edit(Component component) throws Exception;

    /**
     * method to get a sectorComponent by his id
     *
     * @param id
     * @return sectorComponent object
     * @throws Exception
     */
    Component getComponent(Long id) throws Exception;

    /**
     * method to get all sectorComponents
     *
     * @return the sectorComponent list
     */
    List<Component> getAllComponent();

    /**
     * method to get all sectorComponents by his name
     *
     * @param componentName
     * @return the sectorComponent list with his name
     * @throws Exception
     */
    List<Component> getAllComponentByName(String componentName) throws Exception;

    /**
     * method to get all sectorComponents by his ComponentCategory
     *
     * @param componentCategory
     * @return the sectorComponent list from a ComponentCategory
     * @throws Exception
     */
    List<Component> getAllComponentByCategory(ComponentCategory componentCategory) throws Exception;

    /**
     * method to get all sectorComponents by his sector
     *
     * @param sector
     * @return the sectorComponent list with his sector
     * @throws Exception
     */
    List<Component> getAllComponentBySector(Sector sector) throws Exception;

    public void delete(Long valueOf) throws Exception;

}
