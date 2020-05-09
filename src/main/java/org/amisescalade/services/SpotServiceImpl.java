package org.amisescalade.services;

import org.amisescalade.services.interfaces.ISpotService;
import org.amisescalade.services.interfaces.IUserService;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.amisescalade.dao.SpotRepository;
import org.amisescalade.entity.Spot;
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
public class SpotServiceImpl implements ISpotService {

    private static final Logger log = LogManager.getLogger(SpotServiceImpl.class);

    @Autowired
    private SpotRepository spotRepository;

    @Autowired
    private IUserService iUserService;

    @Override
    public Spot register(String spotName, String spotRate, String spotDescription, String spotAccessPath, String location, String country, String username) throws Exception {

        Spot spotFind = spotRepository.findBySpotName(spotName);

        if (spotFind != null) {

            log.error("Le site existe déjà !");

            throw new Exception("Le site existe déjà !");

        }

        Optional<User> spotAuthor = iUserService.getUserByUsername(username);

        if (!spotAuthor.isPresent()) {

            log.error("Utilisateur " + username + " n'existe pas dans la base !");

            throw new Exception("Utilisateur " + username + " n'existe pas dans la base !");

        }

        Spot spot = new Spot();

        spot.setSpotName(spotName);
        spot.setSpotRate(spotRate);
        spot.setSpotDescription(spotDescription);
        spot.setSpotAccessPath(spotAccessPath);
        spot.setLocation(location);
        spot.setCountry(country);

        spot.setSectorCount("0");
        spot.setComponentCount("0");
        spot.setSpotAuthor(spotAuthor.get());
        spot.setSpotDate(new Date());
        spot.setOfficial(false);
        return spotRepository.save(spot);
    }

    @Override
    public Spot edit(Spot spot) throws Exception {

        Optional<Spot> spotFind = spotRepository.findById(spot.getSpotId());

        if (!spotFind.isPresent()) {

            log.error("Modification Impossible ! le spot " + spot.getSpotId() + " n'existe pas dans la base.");

            throw new Exception("Le site " + spot.getSpotId() + " n'existe pas !");

        }

        spotFind.get().setSpotName(spot.getSpotName());
//        spotFind.get().setOfficial(spot.isOfficial());
        spotFind.get().setSpotRate(spot.getSpotRate());
        spotFind.get().setSpotDescription(spot.getSpotDescription());
        spotFind.get().setSpotAccessPath(spot.getSpotAccessPath());
        spotFind.get().setLocation(spot.getLocation());
        spotFind.get().setCountry(spot.getCountry());

        return spotRepository.saveAndFlush(spotFind.get());
    }

    @Override
    public Spot getSpot(Long id) throws Exception {

        Optional<Spot> spotFind = spotRepository.findById(id);

        if (!spotFind.isPresent()) {

            log.error("Le spot " + id + " n'existe pas dans la base.");

            throw new Exception("Le site " + id + " n'existe pas !");

        }
        return spotFind.get();
    }

    @Override
    public Page<Spot> getAllSpots(int p, int s) {

        return spotRepository.findAll(new PageRequest(p, s, Sort.by("spotName")) {
        });
    }

    @Override
    public List<Spot> getAllSpotsByName(String spotname) throws Exception {

        return spotRepository.findBySpotNameContainingIgnoreCase(spotname);
    }

    @Override
    public void delete(Long spotId) throws Exception {

        Optional<Spot> spotFind = spotRepository.findById(spotId);

        if (!spotFind.isPresent()) {

            log.error("Modification Impossible ! le spot " + spotId + " n'existe pas dans la base.");

            throw new Exception("Le site " + spotId + " n'existe pas !");

        }

        spotRepository.deleteById(spotFind.get().getSpotId());
    }

    @Override
    public List<Spot> getAllSpotsByAuthor(String username) throws Exception {

        Optional<User> spotAuthor = iUserService.getUserByUsername(username);

        List<Spot> spotList = spotRepository.findAllBySpotAuthor(spotAuthor.get());

        if (spotList == null) {

            log.info("L'auteur" + username + " n'a pas de spot !");

            throw new Exception("L'auteur" + username + " n'a pas de spot.");

        }

        return spotList;
    }

    @Override
    public List<Spot> getAllSpotsByMc(String spotName, String spotRate, String location, String sectorCount) {

        if (spotName.equals("")) {

            spotName = null;

        }

        if (spotRate.equals("")) {

            spotRate = null;

        }

        if (location.equals("")) {

            location = null;

        }

        if (sectorCount.equals("")) {

            sectorCount = null;

        }

        return spotRepository.findAllSpotsByMc(spotName, spotRate, location, sectorCount);
    }

    @Override
    public Spot modifyStatus(Long id) throws Exception {

        Optional<Spot> spotFind = spotRepository.findById(id);

        if (!spotFind.isPresent()) {

            log.error("Modification Impossible ! le spot " + id + " n'existe pas dans la base.");

            throw new Exception("Le site  " + id + " n'existe pas !");

        }

        if (spotFind.get().isOfficial()) {

            spotFind.get().setOfficial(false);

        } else {

            spotFind.get().setOfficial(true);
        }

        return spotRepository.saveAndFlush(spotFind.get());
    }

}
