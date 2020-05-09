package org.amisescalade.controller;

import java.security.Principal;
import java.util.List;

import org.amisescalade.entity.ComponentCategory;
import org.amisescalade.entity.Sector;
import org.amisescalade.entity.Component;
import org.amisescalade.entity.User;
import org.amisescalade.services.interfaces.IComponentCategoryService;
import org.amisescalade.services.interfaces.IComponentService;
import org.amisescalade.services.interfaces.ISectorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Transactional
public class ComponentController {

    private final Logger log = LogManager.getLogger(ComponentController.class);

    @Autowired
    private IComponentService iComponentService;

    @Autowired
    private IComponentCategoryService iComponentCategoryService;

    @Autowired
    private ISectorService iSectorService;

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public Component editComponent(Component sectorComponent) {

        Component sectorComponentEdit = new Component();

        try {
            sectorComponentEdit = iComponentService.edit(sectorComponent);
        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }

        return sectorComponentEdit;
    }

    public Component displayComponent(Long id) {

        Component sectorComponentFind = new Component();

        try {
            sectorComponentFind = iComponentService.getComponent(id);
        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }
        return sectorComponentFind;
    }

    public List<Component> displayComponentByName(String sectorComponentName) {

        List<Component> sectorComponentList = null;

        try {
            sectorComponentList = iComponentService.getAllComponentByName(sectorComponentName);
        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }
        return sectorComponentList;
    }

    // show add component form with sector
    @GetMapping("/user/sector/{id}/component/add")
    public String showAddComponentForm(@PathVariable("id") int id, Model model) {

        log.debug("showAddComponentForm()");

        Sector sectorFind = null;

        try {
            sectorFind = iSectorService.getSector(Long.valueOf(id));
        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }

        List<ComponentCategory> categoryFind = iComponentCategoryService.getAllComponentCategory();

        model.addAttribute("componentForm", new Component());
        model.addAttribute("sector", sectorFind);
        model.addAttribute("componentCategorys", categoryFind);

        return "/component/addform";

    }

    // save component with sector
    @PostMapping("/user/componentSave/{id}")
    public String saveComponent(@ModelAttribute("componentForm") Component component, @PathVariable("id") int id, Principal principal, final RedirectAttributes redirectAttributes, Model model) {

        log.debug("saveComponent()");

        String sublink = "addform";

        String link = validateIsEmpty(component, sublink, model);

        if (link != null) {

            Sector sectorFind = null;

            try {
                sectorFind = iSectorService.getSector(Long.valueOf(id));
            } catch (Exception ex) {

            }
            model.addAttribute("sector", sectorFind);

            return link;

        }

        Component componentNew = null;
        try {
            componentNew = iComponentService.register(component.getComponentCode(), component.getComponentName(), component.getComponentRate(),
                    component.getComponentDescription(), component.getComponentCategory().getComponentCategoryId(), Long.valueOf(id), principal.getName());
        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e);
            return "redirect:/user/sector/" + id + "/component/add";
        }

        redirectAttributes.addFlashAttribute("msg", "Full succès ! ");

        return "redirect:/component/" + Math.toIntExact(componentNew.getComponentId());

    }

    // show component
    @GetMapping("/component/{id}")
    public String showComponent(@PathVariable("id") Long id, Principal principal, Model model) {

        log.debug("showComponent() id: {}", id);

        Component componentFind = null;

        try {

            componentFind = iComponentService.getComponent(Long.valueOf(id));
        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());

            return "redirect:/components";
        }

        if (principal != null) {

            boolean owner = isOwner(principal.getName(), componentFind.getComponentAuthor().getUsername());
            model.addAttribute("owner", owner);

        } else {

            model.addAttribute("owner", false);
        }

        model.addAttribute("componentFind", componentFind);

        return "/component/show";

    }

    // component list page by sector
    @GetMapping("/sector/{id}/components")
    public String showAllComponents(@PathVariable("id") int id, Model model, Principal principal, final RedirectAttributes redirectAttributes) {

        log.debug("showAllComponents()");

        Sector sectorFind = null;
        List<Component> componentList = null;

        try {
            sectorFind = iSectorService.getSector(Long.valueOf(id));
        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }

        try {
            componentList = iComponentService.getAllComponentBySector(sectorFind);

        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }
        
        if (principal != null) {

            boolean owner = isOwner(principal.getName(), sectorFind.getSectorAuthor().getUsername());
            model.addAttribute("owner", owner);

        } else {

            model.addAttribute("owner", false);
        }

        System.out.println("le post marche !! sector");

        model.addAttribute("components", componentList);
        model.addAttribute("sector", sectorFind);

        return "/component/list";

    }
    
    //delette component
    @PostMapping("/user/component/{id}/delete")
    public String deleteComponent(@PathVariable("id") int id, Principal principal, final RedirectAttributes redirectAttributes) {

        log.debug("deleteSector() id: {}", id);

        hasPermission(principal.getName(), id);

        Component componentFind = null;

        try {

            componentFind = iComponentService.getComponent(Long.valueOf(id));
        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }

        Long sectorId = componentFind.getSector().getSectorId();

        try {
            iComponentService.delete(Long.valueOf(id));
        } catch (Exception e) {
            this.errorMessage = e.getMessage();
        }

        redirectAttributes.addFlashAttribute("msg", "secteur supprimé");

//        return "redirect:/sectors/"+ Math.toIntExact(spotId);
        return "redirect:/sector/" + Math.toIntExact(sectorId) + "/components";

    }
    
    // show update component form :
    @GetMapping("/user/component/{id}/update")
    public String showUpdateComponentForm(@PathVariable("id") int id, Principal principal, Model model) {

        log.debug("showUpdateComponentForm() : {}", id);

        hasPermission(principal.getName(), id);

        Component componentFind = null;

        try {
            componentFind = iComponentService.getComponent(Long.valueOf(id));

        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }

        model.addAttribute("componentFind", componentFind);
        model.addAttribute("sector", componentFind.getSector());

        return "/component/updateform";

    }

    // update component
    @PostMapping("/user/component/update")
    public String UpdateSpot(@ModelAttribute("componentFind") Component component, final RedirectAttributes redirectAttributes, Model model) {

        String sublink = "updateform";

        String link = validateIsEmpty(component, sublink, model);

        if (link != null) {

            return link;

        }

        Component componentUpdate = null;

        try {
            componentUpdate = iComponentService.edit(component);

        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }

        redirectAttributes.addFlashAttribute("msg", "voie modifiée ! ");

        return "redirect:/component/" + Math.toIntExact(componentUpdate.getComponentId());
    }

    public String validateIsEmpty(Component component, String link, Model model) {

        if (component.getComponentName().isEmpty()) {

            model.addAttribute("error", "name  isEmpty");

            return "sector/" + link;

        }

        if (component.getComponentRate().isEmpty()) {

            model.addAttribute("error", "rate  isEmpty");

            return "sector/" + link;

        }
        return null;

    }
    
    public boolean isOwner(String username, String userFind) {

        System.out.println(username);

        System.out.println(userFind);

        System.out.println(username.equals(userFind));

        if (username.equals(userFind)) {

            return true;

        }

        return false;

    }
    
     public String hasPermission(String username, int id) {

        User userFind = null;

        try {

            userFind = iSectorService.getSector(Long.valueOf(id)).getSectorAuthor();

            if (username.equals(userFind)) {
                return null;
            }

        } catch (Exception ex) {

            return "redirect:/sector/" + id;

        }

        return "redirect:/sector/" + id;

    }

}
