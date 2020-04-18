package org.amisescalade.services;

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

    @Override
    public Spot register(String spotName, String spotRate, String spotDescription, String spotAccessPath, String departement, String country, String sectorCount, String sectorDescription, String routeCount, String routeDescription, User spotAuthor) throws Exception {

        Spot spotFind = spotRepository.findBySpotName(spotName);

        if (spotFind != null) {

            log.error("Le site existe déjà !");

            throw new Exception("Le site existe déjà !");

        }

        Spot spot = new Spot();

        spot.setSpotName(spotName);
        spot.setSpotRate(spotRate);
        spot.setSpotDescription(spotDescription);
        spot.setSpotAccessPath(spotAccessPath);
        spot.setDepartement(departement);
        spot.setCountry(country);

        // Spot detail
        spot.setSectorCount(sectorCount);
        spot.setSectorDescription(sectorDescription);
        spot.setRouteCount(routeCount);
        spot.setRouteDescription(routeDescription);

        spot.setSpotAuthor(spotAuthor);
        spot.setSpotDate(new Date());
        spot.setOfficial(false);
        return spotRepository.save(spot);
    }

    @Override
    public Spot edit(Spot spot) throws Exception {

        Optional<Spot> spotFind = spotRepository.findById(spot.getSpotId());

        if (!spotFind.isPresent()) {

            log.error("Modification Impossible ! le spot " + spot.getSpotId() + " n'existe pas dans la base.");

            throw new Exception("Le spot n'existe pas !");

        }

        spotFind.get().setSpotName(spot.getSpotName());
        spotFind.get().setOfficial(spot.isOfficial());
        spotFind.get().setSpotRate(spot.getSpotRate());
        spotFind.get().setSpotDescription(spot.getSpotDescription());
        spotFind.get().setSpotAccessPath(spot.getSpotAccessPath());
        spotFind.get().setDepartement(spot.getDepartement());
        spotFind.get().setCountry(spot.getCountry());

        return spotRepository.saveAndFlush(spotFind.get());
    }

    @Override
    public Spot getSpot(Long id) throws Exception {

        Optional<Spot> spotFind = spotRepository.findById(id);

        if (!spotFind.isPresent()) {

            log.error("Modification Impossible ! le spot " + id + " n'existe pas dans la base.");

            throw new Exception("Le spot n'existe pas !");

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
    public void delete(Long spotId) {

        spotRepository.deleteById(spotId);
    }

    @Override
    public List<Spot> getAllSpotsByNameRateDepartement(String spotRate, String departement, String sectorCount) {
//        return null;
        return spotRepository.findBySpotRateAndDepartementAndSectorCountAllIgnoreCase(spotRate, departement, sectorCount);
    }

}
