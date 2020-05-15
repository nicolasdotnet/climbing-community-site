package org.amisescalade.services;

import org.amisescalade.services.interfaces.ISectorService;
import org.amisescalade.services.interfaces.ISpotService;
import org.amisescalade.services.interfaces.IUserService;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.amisescalade.dao.SectorRepository;
import org.amisescalade.entity.Sector;
import org.amisescalade.entity.Spot;
import org.amisescalade.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SectorServiceImpl implements ISectorService {

    private static final Logger log = LogManager.getLogger(SectorServiceImpl.class);

    @Autowired
    private SectorRepository sectorRepository;

    @Autowired
    private ISpotService iSpotService;

    @Autowired
    private IUserService iUserService;

    @Override
    public Sector registerBySpot(String sectorName, String sectorRate, String sectorDescription,
            String sectorAccessPath, Long spotId, String username) throws Exception {

        Spot spotFind = iSpotService.getSpot(spotId);

        if (spotFind == null) {

            log.error("Le spot " + spotId + " n'existe pas dans la base !");

            throw new Exception("Le site " + spotId + " n'existe pas dans la base !");

        }

        Optional<User> sectorAuthor = iUserService.getUserByUsername(username);

        if (!sectorAuthor.isPresent()) {

            log.error("Utilisateur " + username + " n'existe pas dans la base !");

            throw new Exception("Utilisateur " + username + " n'existe pas dans la base !");

        }

        if (sectorName.length() > 150) {

            log.error("Enregistrement du sector impossible ! sectorName est trop long.");

            throw new Exception("Enregistrement du secteur impossible ! le nom est trop long.");

        }

        if (sectorRate.length() > 3) {

            log.error("Enregistrement du sector impossible ! sectorRate est trop long.");

            throw new Exception("Enregistrement du secteur impossible ! la cotation est trop longue.");

        }

        if (sectorDescription.length() > 380) {

            log.error("Enregistrement du sector impossible ! sectorDescription est trop long.");

            throw new Exception("Enregistrement du secteur impossible ! la description est trop longue.");

        }

        if (sectorAccessPath.length() > 170) {

            log.error("Enregistrement du sector impossible ! le chemin d'accès est trop long.");

            throw new Exception("Enregistrement du secteur impossible ! le chemin d'accès est trop long.");

        }

        Sector sector = new Sector();

        sector.setSectorName(sectorName);
        sector.setSectorRate(sectorRate);
        sector.setSectorDescription(sectorDescription);
        sector.setSectorAccessPath(sectorAccessPath);
        sector.setSpot(spotFind);
        sector.setSectorAuthor(sectorAuthor.get());
        sector.setSectorDate(new Date());

        int i = Integer.parseInt(spotFind.getSectorCount());
        ++i;
        spotFind.setSectorCount(String.valueOf(i));

        return sectorRepository.save(sector);
    }

    @Override
    public Sector edit(Sector sector) throws Exception {

        Optional<Sector> sectorFind = sectorRepository.findById(sector.getSectorId());

        if (!sectorFind.isPresent()) {

            log.error("Modification Impossible ! le sector " + sector.getSectorId() + " n'existe pas dans la base.");

            throw new Exception("Le secteur " + sector.getSectorId() + " n'existe pas !");

        }

        if (sector.getSectorName().length() > 150) {

            log.error("Enregistrement du sector impossible ! sectorName est trop long.");

            throw new Exception("Enregistrement du secteur impossible ! le nom est trop long.");

        }

        if (sector.getSectorRate().length() > 3) {

            log.error("Enregistrement du sector impossible ! sectorRate est trop long.");

            throw new Exception("Enregistrement du secteur impossible ! la cotation est trop longue.");

        }

        if (sector.getSectorDescription().length() > 380) {

            log.error("Enregistrement du sector impossible ! sectorDescription est trop long.");

            throw new Exception("Enregistrement du secteur impossible ! la description est trop longue.");

        }

        if (sector.getSectorAccessPath().length() > 170) {

            log.error("Enregistrement du sector impossible ! le chemin d'accès est trop long.");

            throw new Exception("Enregistrement du secteur impossible ! le chemin d'accès est trop long.");

        }

        sectorFind.get().setSectorName(sector.getSectorName());
        sectorFind.get().setSectorRate(sector.getSectorRate());
        sectorFind.get().setSectorDescription(sector.getSectorDescription());
        sectorFind.get().setSectorAccessPath(sector.getSectorAccessPath());

        return sectorRepository.saveAndFlush(sectorFind.get());
    }

    @Override
    public Sector getSector(Long id) throws Exception {

        Optional<Sector> sectorFind = sectorRepository.findById(id);

        if (!sectorFind.isPresent()) {

            log.error("Le sector " + id + " n'existe pas dans la base.");

            throw new Exception("Le secteur " + id + " n'existe pas !");

        }
        return sectorFind.get();
    }

    @Override
    public void delete(Long sectorId) throws Exception {

        Optional<Sector> sectorFind = sectorRepository.findById(sectorId);

        if (!sectorFind.isPresent()) {

            log.error("Suppresion Impossible ! le sector " + sectorId + " n'existe pas dans la base.");

            throw new Exception("Suppresion Impossible ! Le secteur " + sectorId + " n'existe pas !");

        }

        int i = Integer.parseInt(sectorFind.get().getSpot().getSectorCount());
        --i;
        sectorFind.get().getSpot().setSectorCount(String.valueOf(i));

        sectorRepository.deleteById(sectorId);
    }

    @Override
    public List<Sector> getAllSectors() {

        return sectorRepository.findAll();
    }

    @Override
    public List<Sector> getAllSectorsByName(String sectorName) throws Exception {

        return sectorRepository.findBySectorNameContainingIgnoreCase(sectorName);
    }

    @Override
    public List<Sector> getAllSectorsBySpot(Spot spot) throws Exception {

        return sectorRepository.findBySpot(spot);
    }

}
