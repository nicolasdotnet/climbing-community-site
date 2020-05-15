/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amisescalade.services;

import org.amisescalade.services.interfaces.IComponentService;
import org.amisescalade.services.interfaces.IPitchService;
import org.amisescalade.services.interfaces.IUserService;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.amisescalade.dao.PitchRepository;
import org.amisescalade.entity.Component;
import org.amisescalade.entity.Pitch;
import org.amisescalade.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PitchServiceImpl implements IPitchService {

    private static final Logger log = LogManager.getLogger(PitchServiceImpl.class);

    @Autowired
    private PitchRepository pitchRepository;

    @Autowired
    private IComponentService iComponentService;

    @Autowired
    private IUserService iUserService;

    @Override
    public Pitch register(String pitchCode, String pitchHeight, String pitchRate, Long componentId, String username) throws Exception {

        Component componentFind = iComponentService.getComponent(componentId);

        if (componentFind == null) {

            log.error("Le component " + componentId + " n'existe pas dans la base !");

            throw new Exception("La voie/bloc " + componentId + " n'existe pas dans la base !");

        }

        Optional<User> pitchAuthor = iUserService.getUserByUsername(username);

        if (!pitchAuthor.isPresent()) {

            log.error("Utilisateur " + username + " n'existe pas dans la base !");

            throw new Exception("Utilisateur " + username + " n'existe pas dans la base !");

        }

        if (pitchCode.length() > 3) {

            log.error("Enregistrement du pitch impossible ! pitchRate est trop long.");

            throw new Exception("Enregistrement de la longueur impossible ! la numérotation est trop longue.");

        }

        if (pitchHeight.length() > 3) {

            log.error("Enregistrement du pitch impossible ! pitchHeight est trop long.");

            throw new Exception("Enregistrement de la longueur impossible ! la hauteur est trop longue.");

        }

        if (pitchRate.length() > 3) {

            log.error("Enregistrement du  pitch impossible ! pitchRate est trop long.");

            throw new Exception("Enregistrement de la longueur impossible ! la cotation est trop longue.");

        }

        String number = "[0-9]+";

        if (!pitchHeight.matches(number)) {

            log.error("Que des chiffres 0-9 pour la hauteur !");

            throw new Exception("Que des chiffres 0-9 pour la hauteur !");

        }

        if (!pitchCode.matches(number)) {

            log.error("Que des chiffres 0-9 pour la hauteur !");

            throw new Exception("Que des chiffres 0-9 pour la numérotation !");

        }

        Pitch pitch = new Pitch();

        pitch.setPitchCode(pitchCode);
        pitch.setPitchHeight(pitchHeight);
        pitch.setPitchRate(pitchRate);
        pitch.setComponent(componentFind);
        pitch.setPitchAuthor(pitchAuthor.get());
        pitch.setPitchDate(new Date());

        return pitchRepository.save(pitch);
    }

    @Override
    public Pitch edit(Pitch pitch) throws Exception {

        Optional<Pitch> pitchFind = pitchRepository.findById(pitch.getPitchId());

        if (!pitchFind.isPresent()) {

            log.error("Modification Impossible ! le pitch " + pitch.getPitchId() + " n'existe pas dans la base.");

            throw new Exception("La longeur " + pitch.getPitchId() + "n'existe pas !");

        }

        if (pitch.getPitchCode().length() > 3) {

            log.error("Enregistrement du pitch impossible ! pitchRate est trop long.");

            throw new Exception("Enregistrement de la longueur impossible ! la numérotation est trop longue.");

        }

        if (pitch.getPitchHeight().length() > 3) {

            log.error("Enregistrement du pitch impossible ! pitchHeight est trop long.");

            throw new Exception("Enregistrement de la longueur impossible ! la hauteur est trop longue.");

        }

        if (pitch.getPitchRate().length() > 3) {

            log.error("Enregistrement du  pitch impossible ! pitchRate est trop long.");

            throw new Exception("Enregistrement de la longueur impossible ! la cotation est trop longue.");

        }

        String number = "[0-9]+";

        if (!pitch.getPitchHeight().matches(number)) {

            log.error("Que des chiffres 0-9 pour la hauteur !");

            throw new Exception("Que des chiffres 0-9 pour la hauteur !");

        }

        if (!pitch.getPitchCode().matches(number)) {

            log.error("Que des chiffres 0-9 pour la hauteur !");

            throw new Exception("Que des chiffres 0-9 pour la numérotation !");

        }

        pitchFind.get().setPitchCode(pitch.getPitchCode());
        pitchFind.get().setPitchHeight(pitch.getPitchHeight());
        pitchFind.get().setPitchRate(pitch.getPitchRate());

        return pitchRepository.saveAndFlush(pitchFind.get());
    }

    @Override
    public Pitch getPitch(Long id) throws Exception {

        Optional<Pitch> pitchFind = pitchRepository.findById(id);

        if (!pitchFind.isPresent()) {

            log.error("La pitch" + id + " n'existe pas dans la base.");

            throw new Exception("La longeur " + id + " n'existe pas !");

        }
        return pitchFind.get();
    }

    @Override
    public List<Pitch> getAllPitch() {
        return pitchRepository.findAll();
    }

    @Override
    public List<Pitch> getAllPitchsByComponent(Component component) throws Exception {
        return pitchRepository.findByComponent(component);
    }

    @Override
    public void delete(Long pitchId) throws Exception {

        Optional<Pitch> pitchFind = pitchRepository.findById(pitchId);

        if (!pitchFind.isPresent()) {

            log.error("Suppresion Impossible ! le pitch " + pitchId + " n'existe pas dans la base.");

            throw new Exception("Suppresion Impossible ! La longeur " + pitchId + " n'existe pas !");

        }

        pitchRepository.deleteById(pitchId);
    }

}
