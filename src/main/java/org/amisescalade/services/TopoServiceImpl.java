package org.amisescalade.services;

import org.amisescalade.services.interfaces.ITopoService;
import org.amisescalade.services.interfaces.IUserService;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.amisescalade.dao.TopoRepository;
import org.amisescalade.entity.Topo;
import org.amisescalade.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TopoServiceImpl implements ITopoService {

    private static final Logger log = LogManager.getLogger(TopoServiceImpl.class);

    @Autowired
    private TopoRepository topoRepository;

    @Autowired
    private IUserService iUserService;

    @Override
    public Topo register(String topoArea, String topoTitle, String topoDescription,Date releaseDate, User topoOwner) throws Exception {
        
        if (releaseDate.after(new Date())) {
            
            log.error("Enregistrement du topo Impossible ! la date de parution " + releaseDate + " est supérieur à la date du jour.");

            throw new Exception("Enregistrement du topo Impossible ! la date de parution " + releaseDate + " est supérieur à la date du jour.");
            
        }

        Topo topo = new Topo();
        topo.setTopoArea(topoArea);
        topo.setTopoTitle(topoTitle);
        topo.setTopoDescription(topoDescription);
        topo.setReleaseDate(releaseDate);
        topo.setTopoOwner(topoOwner);

        
        topo.setTopoDate(new Date());
        topo.setTopoStatus(true);

        return topoRepository.save(topo);
    }

    @Override
    public Topo edit(Topo topo) throws Exception {

        Optional<Topo> topoFind = topoRepository.findById(topo.getTopoId());

        if (!topoFind.isPresent()) {

            log.error("Modification Impossible ! le topo " + topo.getTopoId() + " n'existe pas dans la base.");

            throw new Exception("Le topo " + topo.getTopoId() + " n'existe pas !");
        }

        topoFind.get().setTopoArea(topo.getTopoArea());
        topoFind.get().setTopoDescription(topo.getTopoDescription());
        topoFind.get().setTopoTitle(topo.getTopoTitle());
        topoFind.get().setTopoStatus(topo.getTopoStatus());

        return topoRepository.saveAndFlush(topoFind.get());
    }

    @Override
    public Topo getTopo(Long id) throws Exception {

        Optional<Topo> topoFind = topoRepository.findById(id);

        if (!topoFind.isPresent()) {

            log.error("Le topo " + id + " n'existe pas dans la base.");

            throw new Exception("Le topo " + id + " n'existe pas !");

        }
        return topoFind.get();
    }

    @Override
    public Page<Topo> getAllTopos(int p, int s) {

        return topoRepository.findAll(new PageRequest(p, s, Sort.by("topoTitle")) {
        });
    }

    @Override
    public List<Topo> getTopoByTitle(String title) throws Exception {

        return topoRepository.findByTopoTitleContainingIgnoreCase(title);
    }

    @Override
    public void delete(Long topoId) throws Exception {
        
        Optional<Topo> topoFind = topoRepository.findById(topoId);
        
        if (!topoFind.isPresent()) {

            log.error("Modification Impossible ! le topo " + topoId + " n'existe pas dans la base.");

            throw new Exception("Le topo " + topoId + "n'existe pas !");

        }

        topoRepository.deleteById(topoId);

    }

    @Override
    public Topo changeStatus(Topo topo) throws Exception {

        Optional<Topo> topoFind = topoRepository.findById(topo.getTopoId());

        if (!topoFind.isPresent()) {

            log.error("Modification Impossible ! le topo " + topo.getTopoId() + " n'existe pas dans la base.");

            throw new Exception("Le topo " + topo.getTopoId() + " n'existe pas !");
        }

        topoFind.get().setTopoStatus(topo.getTopoStatus());

        return topoRepository.saveAndFlush(topoFind.get());

    }

    @Override
    public List<Topo> getAllToposByOwner(User ownerTopo) throws Exception {

        Optional<User> owner = iUserService.getUserByUsername(ownerTopo.getUsername());

        List<Topo> topoList = topoRepository.findByTopoOwner(owner.get());

        if (topoList == null) {

            log.info("Le propriétaire" + ownerTopo.getUsername() + " n'a pas de topo.");

            throw new Exception("Le propriétaire" + ownerTopo.getUsername() + " n'a pas de topo.");

        }

        return topoList;

    }

}
