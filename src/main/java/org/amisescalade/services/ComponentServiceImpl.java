package org.amisescalade.services;

import org.amisescalade.services.interfaces.IComponentCategoryService;
import org.amisescalade.services.interfaces.ISectorService;
import org.amisescalade.services.interfaces.IComponentService;
import org.amisescalade.services.interfaces.IUserService;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.amisescalade.dao.ComponentRepository;
import org.amisescalade.entity.ComponentCategory;
import org.amisescalade.entity.Sector;
import org.amisescalade.entity.Component;
import org.amisescalade.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ComponentServiceImpl implements IComponentService {

    private static final Logger log = LogManager.getLogger(ComponentServiceImpl.class);

    @Autowired
    private ComponentRepository componentRepository;

    @Autowired
    private ISectorService iSectorService;

    @Autowired
    private IComponentCategoryService iComponentCategoryService;

    @Autowired
    private IUserService iUserService;

    @Override
    public Component register(String componentCode, String componentName, String componentRate, String componentHeight, Boolean spits,
            String componentDescription, Long componentCategoryId, Long sectorId, String username) throws Exception {

        Sector sectorFind = iSectorService.getSector(sectorId);

        if (sectorFind == null) {

            log.error("Le sector " + sectorId + " n'existe pas dans la base !");

            throw new Exception("Le secteur " + sectorId + " n'existe pas dans la base !");

        }

        ComponentCategory componentCategoryFind = iComponentCategoryService.getComponentCategory(componentCategoryId);

        if (componentCategoryFind == null) {

            log.error("La categorie " + componentCategoryId + " n'existe pas dans la base !");

            throw new Exception("La categorie " + componentCategoryId + " n'existe pas dans la base !");

        }

        Optional<User> componentAuthor = iUserService.getUserByUsername(username);

        if (!componentAuthor.isPresent()) {

            log.error("Utilisateur " + username + " n'existe pas dans la base !");

            throw new Exception("Utilisateur " + username + " n'existe pas dans la base !");

        }

        if (componentCode.length() > 5) {

            log.error("Enregistrement du component impossible ! componentCode est trop long.");

            throw new Exception("Enregistrement de la voie impossible ! le numéro du bloc est trop long.");

        }

        if (componentRate.length() > 3) {

            log.error("Enregistrement du component impossible ! componentRate est trop long.");

            throw new Exception("Enregistrement de la voie impossible ! la cotation est trop long.");

        }

        if (componentName.length() > 150) {

            log.error("Enregistrement du component impossible ! componentName est trop long.");

            throw new Exception("Enregistrement de la voie impossible ! le nom est trop long.");

        }

        if (componentHeight.length() > 3) {

            log.error("Enregistrement du component impossible ! componentHeight est trop long.");

            throw new Exception("Enregistrement de la voie impossible ! la hauteur est trop longue.");

        }

        String number = "[0-9]+";

        if (!componentHeight.matches(number)) {

            log.error("Que des chiffres 0-9 pour la hauteur !");

            throw new Exception("Que des chiffres 0-9 pour la hauteur !");

        }

        if (componentDescription.length() > 380) {

            log.error("Enregistrement du component impossible ! la description est trop longue.");

            throw new Exception("Enregistrement de la voie impossible ! la description est trop longue.");

        }

        Component component = new Component();

        component.setComponentCode(componentCode);
        component.setComponentName(componentName);
        component.setComponentRate(componentRate);
        component.setComponentHeight(componentHeight);
        component.setSpits(spits);
        component.setComponentDescription(componentDescription);
        component.setComponentCategory(componentCategoryFind);
        component.setSector(sectorFind);
        component.setComponentAuthor(componentAuthor.get());
        component.setComponentDate(new Date());

        int i = Integer.parseInt(sectorFind.getSpot().getComponentCount());
        ++i;
        sectorFind.getSpot().setComponentCount(String.valueOf(i));

        return componentRepository.save(component);
    }

    @Override
    public Component edit(Component component) throws Exception {

        Optional<Component> componentFind = componentRepository.findById(component.getComponentId());

        if (!componentFind.isPresent()) {

            log.error("Modification Impossible ! le component " + component.getComponentId() + " n'existe pas dans la base.");

            throw new Exception("La voie/bloc" + component.getComponentId() + " n'existe pas !");

        }

        if (component.getComponentCode().length() > 5) {

            log.error("Enregistrement du component impossible ! componentCode est trop long.");

            throw new Exception("Enregistrement de la voie impossible ! le numéro du bloc est trop long.");

        }

        if (component.getComponentRate().length() > 3) {

            log.error("Enregistrement du component impossible ! componentRate est trop long.");

            throw new Exception("Enregistrement de la voie impossible ! la cotation est trop long.");

        }

        if (component.getComponentName().length() > 150) {

            log.error("Enregistrement du component impossible ! componentName est trop long.");

            throw new Exception("Enregistrement de la voie impossible ! le nom est trop long.");

        }

        if (component.getComponentHeight().length() > 3) {

            log.error("Enregistrement du component impossible ! componentHeight est trop long.");

            throw new Exception("Enregistrement de la voie impossible ! la hauteur est trop longue.");

        }

        String number = "[0-9]+";

        if (!component.getComponentHeight().matches(number)) {

            log.error("Que des chiffres 0-9 pour la hauteur !");

            throw new Exception("Que des chiffres 0-9 pour la hauteur !");

        }

        if (component.getComponentDescription().length() > 380) {

            log.error("Enregistrement du component impossible ! la description est trop longue.");

            throw new Exception("Enregistrement de la voie impossible ! la description est trop longue.");

        }

        componentFind.get().setComponentName(component.getComponentName());
        componentFind.get().setComponentDescription(component.getComponentDescription());
        componentFind.get().setComponentRate(component.getComponentRate());
        componentFind.get().setComponentCode(component.getComponentCode());
        componentFind.get().setComponentHeight(component.getComponentHeight());
        componentFind.get().setSpits(component.getSpits());
        componentFind.get().setComponentCategory(component.getComponentCategory());

        return componentRepository.saveAndFlush(componentFind.get());
    }

    @Override
    public Component getComponent(Long id) throws Exception {

        Optional<Component> sectorComponent = componentRepository.findById(id);

        if (!sectorComponent.isPresent()) {

            log.error("Le component " + id + " n'existe pas dans la base.");

            throw new Exception("La voie/bloc" + id + " n'existe pas !");

        }
        return sectorComponent.get();
    }

    @Override
    public List<Component> getAllComponent() {

        return componentRepository.findAll();
    }

    @Override
    public List<Component> getAllComponentByName(String componentName) throws Exception {

        return componentRepository.findByComponentNameContainingIgnoreCase(componentName);
    }

    @Override
    public List<Component> getAllComponentByCategory(ComponentCategory componentCategory)
            throws Exception {

        return componentRepository.findByComponentCategory(componentCategory);
    }

    @Override
    public List<Component> getAllComponentBySector(Sector sector) throws Exception {

        return componentRepository.findBySector(sector);
    }

    @Override
    public void delete(Long componentId) throws Exception {

        Optional<Component> componentFind = componentRepository.findById(componentId);

        if (!componentFind.isPresent()) {

            log.error("Suppresion Impossible ! le component " + componentId + " n'existe pas dans la base.");

            throw new Exception("Suppresion Impossible ! La voie/bloc " + componentId + "n'existe pas !");

        }

        int i = Integer.parseInt(componentFind.get().getSector().getSpot().getComponentCount());
        --i;
        componentFind.get().getSector().getSpot().setComponentCount(String.valueOf(i));

        componentRepository.deleteById(componentId);
    }

}
