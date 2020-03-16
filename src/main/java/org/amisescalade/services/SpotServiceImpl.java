package org.amisescalade.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.amisescalade.dao.SpotRepository;
import org.amisescalade.entity.Spot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SpotServiceImpl implements ISpotService {

    private static final Logger log = LogManager.getLogger(SpotServiceImpl.class);

    @Autowired
    private SpotRepository spotRepository;

    @Override
    public Spot register(String spotName, String spotRate, String spotDescription, String spotAccessPath, String departement, String country) throws Exception {

        // TODO check by title for no register double ?
        Spot spot = new Spot();

        spot.setSpotName(spotName);
        spot.setSpotRate(spotRate);
        spot.setSpotDescription(spotDescription);
        spot.setSpotAccessPath(spotAccessPath);
        spot.setDepartement(departement);
        spot.setCountry(country);

        spot.setSpotDate(new Date());
        return spotRepository.save(spot);
    }

    @Override
    public Spot edit(Spot spot) throws Exception {

        Optional<Spot> topoFind = spotRepository.findById(spot.getSpotId());

        if (!topoFind.isPresent()) {

            log.error("Modification Impossible ! le spot " + spot.getSpotId() + " n'existe pas dans la base.");

            throw new Exception("Le spot n'existe pas !");

        }

        return spotRepository.saveAndFlush(spot);
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
    public List<Spot> getAllSpots() {

        return spotRepository.findAll();
    }

    @Override
    public List<Spot> getAllSpotsByName(String spotname) throws Exception {

        return spotRepository.findBySpotNameContainingIgnoreCase(spotname);
    }

    @Override
    public void delete(Long id) {

        spotRepository.deleteById(id);
    }

}
