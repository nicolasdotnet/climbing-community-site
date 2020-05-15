package org.amisescalade.services.interfaces;

import java.util.Date;
import java.util.List;

import org.amisescalade.entity.Topo;
import org.amisescalade.entity.User;
import org.springframework.data.domain.Page;

public interface ITopoService {

    /**
     * method to register a topo
     *
     * @param topoArea
     * @param topoTitle
     * @param topoDescription
     * @param releaseDate
     * @param topoOwner
     * @return topo object saved
     * @throws Exception
     */
    Topo register(String topoArea, String topoTitle, String topoDescription, Date releaseDate, User topoOwner) throws Exception;

    /**
     * method to modify a topo
     *
     * @param topo
     * @return topo object modified
     * @throws Exception
     */
    Topo edit(Topo topo) throws Exception;

    /**
     * method to get a topo by his id
     *
     * @param id
     * @return topo object
     * @throws Exception
     */
    Topo getTopo(Long id) throws Exception;

    /**
     * method to get all topos
     *
     * @param p
     * @param s
     * @return the topo page
     */
    Page<Topo> getAllTopos(int p, int s);

    /**
     * method to get all topos by Owner
     *
     * @param OwnerTopo
     * @return the topo list
     * @throws Exception
     */
    List<Topo> getAllToposByOwner(User OwnerTopo) throws Exception;

    /**
     * method to get a topo by his title
     *
     * @param title
     * @return the topo list with his title
     * @throws Exception
     */
    List<Topo> getTopoByTitle(String title) throws Exception;

    /**
     * method to remove a topo
     *
     * @param topoId
     * @throws java.lang.Exception
     */
    void delete(Long topoId) throws Exception;

    /**
     *
     * @param topo
     * @return
     * @throws Exception
     */
    Topo changeStatus(Topo topo) throws Exception;

}
