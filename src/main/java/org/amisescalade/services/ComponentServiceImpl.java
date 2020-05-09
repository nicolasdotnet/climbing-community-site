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
    public Component register(String componentCode, String componentName, String componentRate, String componentDescription, Long componentCategoryId, Long sectorId, String username) throws Exception {

        Component componentFind = componentRepository.findByComponentCode(componentCode);

        if (componentFind != null) {

            log.error("Le component " + componentName + " existe déjà !");

            throw new Exception("La voie/bloc " + componentName + " existe déjà !");

        }

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

        Component sectorComponent = new Component();

        sectorComponent.setComponentCode(componentCode);
        sectorComponent.setComponentName(componentName);
        sectorComponent.setComponentRate(componentRate);
        sectorComponent.setComponentDescription(componentDescription);
        sectorComponent.setComponentCategory(componentCategoryFind);
        sectorComponent.setSector(sectorFind);
        sectorComponent.setComponentAuthor(componentAuthor.get());
        sectorComponent.setComponentDate(new Date());

        int i = Integer.parseInt(componentFind.getSector().getSpot().getComponentCount());
        --i;
        componentFind.getSector().getSpot().setComponentCount(String.valueOf(i));

        return componentRepository.save(sectorComponent);
    }

    @Override
    public Component edit(Component sectorComponent) throws Exception {

        Optional<Component> componentFind = componentRepository.findById(sectorComponent.getComponentId());

        if (!componentFind.isPresent()) {

            log.error("Modification Impossible ! le component " + sectorComponent.getComponentId() + " n'existe pas dans la base.");

            throw new Exception("La voie/bloc" + sectorComponent.getComponentId() + " n'existe pas !");

        }

        componentFind.get().setComponentName(sectorComponent.getComponentName());
        componentFind.get().setComponentDescription(sectorComponent.getComponentDescription());
        componentFind.get().setComponentRate(sectorComponent.getComponentRate());
        componentFind.get().setComponentCode(sectorComponent.getComponentCode());

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
