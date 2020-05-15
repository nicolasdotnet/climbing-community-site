package org.amisescalade.controller;

import java.security.Principal;
import java.util.List;

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
//@Transactional
public class ComponentController {

    private final Logger log = LogManager.getLogger(ComponentController.class);

    @Autowired
    private IComponentService iComponentService;

    @Autowired
    private IComponentCategoryService iComponentCategoryService;

    @Autowired
    private ISectorService iSectorService;

    // show add component form with sector
    @GetMapping("/user/sector/{id}/component/add")
    public String showAddComponentForm(@PathVariable("id") int id, Model model, final RedirectAttributes redirectAttributes) {

        log.debug("showAddComponentForm()");

        Sector sectorFind = null;

        try {
            sectorFind = iSectorService.getSector(Long.valueOf(id));
        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/sector/" + id;
        }

        model.addAttribute("componentForm", new Component());
        model.addAttribute("sector", sectorFind);
        model.addAttribute("componentCategorys", iComponentCategoryService.getAllComponentCategory());

        return "/component/addform";

    }

    // save component with sector
    @PostMapping("/user/componentSave/{id}")
    public String saveComponent(@ModelAttribute("componentForm") Component component, @PathVariable("id") int id, Principal principal, final RedirectAttributes redirectAttributes, Model model) {

        log.debug("saveComponent()");

        String sublink = "addform";

        String link = validateIsEmpty(component, sublink, model);
        
        Sector sectorFind = null;

            try {
                sectorFind = iSectorService.getSector(Long.valueOf(id));

            } catch (Exception e) {

                redirectAttributes.addFlashAttribute("error", e.getMessage());
                return "redirect:/user/sector/" + id + "/component/add";

            }

        if (link != null) {

            model.addAttribute("sector", sectorFind);
            model.addAttribute("componentCategorys", iComponentCategoryService.getAllComponentCategory());

            return link;

        }

        Component componentNew = null;
        try {
            componentNew = iComponentService.register(component.getComponentCode(), component.getComponentName(), component.getComponentRate(),
                    component.getComponentHeight(), component.getSpits(), component.getComponentDescription(), component.getComponentCategory().getComponentCategoryId(),
                    Long.valueOf(id), principal.getName());

        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());
            model.addAttribute("sector", sectorFind);
            model.addAttribute("componentForm", component);
            model.addAttribute("componentCategorys", iComponentCategoryService.getAllComponentCategory());
            
            return "/component/addform";
        }

        redirectAttributes.addFlashAttribute("msg", "Voie enregistrée ! ");

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

            return "common/infos";
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

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/sector/" + id;
        }

        try {
            componentList = iComponentService.getAllComponentBySector(sectorFind);

        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/sector/" + id;
        }

        if (principal != null) {

            boolean owner = isOwner(principal.getName(), sectorFind.getSectorAuthor().getUsername());
            model.addAttribute("owner", owner);

        } else {

            model.addAttribute("owner", false);
        }

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

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/component/" + id;
        }

        Long sectorId = componentFind.getSector().getSectorId();

        try {
            iComponentService.delete(Long.valueOf(id));
        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/component/" + id;
        }

        redirectAttributes.addFlashAttribute("msg", "Voie supprimée !");

        return "redirect:/sector/" + Math.toIntExact(sectorId) + "/components";

    }

    // show update component form :
    @GetMapping("/user/component/{id}/update")
    public String showUpdateComponentForm(@PathVariable("id") int id, Principal principal, Model model, final RedirectAttributes redirectAttributes) {

        log.debug("showUpdateComponentForm() : {}", id);

        hasPermission(principal.getName(), id);

        Component componentFind = null;

        try {
            componentFind = iComponentService.getComponent(Long.valueOf(id));

        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/component/" + id;
        }

        model.addAttribute("componentFind", componentFind);
        model.addAttribute("sector", componentFind.getSector());
        model.addAttribute("componentCategorys", iComponentCategoryService.getAllComponentCategory());

        return "/component/updateform";

    }

    // update component
    @PostMapping("/user/component/update")
    public String UpdateSpot(@ModelAttribute("componentFind") Component component, final RedirectAttributes redirectAttributes, Model model) {

        String sublink = "updateform";

        String link = validateIsEmpty(component, sublink, model);

        if (link != null) {

            model.addAttribute("componentCategorys", iComponentCategoryService.getAllComponentCategory());

            return link;

        }

        Component componentUpdate = null;

        try {
            componentUpdate = iComponentService.edit(component);

        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/user/component/" + Math.toIntExact(component.getComponentId())+"/update";

        }

        redirectAttributes.addFlashAttribute("msg", "Voie modifiée ! ");

        return "redirect:/component/" + Math.toIntExact(componentUpdate.getComponentId());
    }

    public String validateIsEmpty(Component component, String link, Model model) {

        if (component.getComponentName().isEmpty()) {

            model.addAttribute("error", "Le nom du site n'est pas renseigné");

            return "component/" + link;

        }

        if (component.getComponentRate().isEmpty()) {

            model.addAttribute("error", "La cotation n'est pas renseignée");

            return "component/" + link;

        }

        if (component.getComponentHeight().isEmpty()) {

            model.addAttribute("error", "La hauteur n'est pas renseignée");

            return "component/" + link;

        } else {

            if (!isNumber(component.getComponentHeight())) {

                model.addAttribute("error", "Que des chiffres 0-9 pour la hauteur !");

                return "component/" + link;
            }

        }

        return null;

    }

    public boolean isOwner(String username, String userFind) {

        if (username.equals(userFind)) {

            return true;

        }

        return false;

    }

    public String hasPermission(String username, int id) {

        User userFind = null;

        try {

            userFind = iComponentService.getComponent(Long.valueOf(id)).getComponentAuthor();

            if (username.equals(userFind)) {
                return null;
            }

        } catch (Exception ex) {

            return "redirect:/component/" + id;

        }

        return "redirect:/component/" + id;

    }

    public boolean isNumber(String height) {

        String number = "[0-9]+";

        if (height.matches(number)) {
            
            return true;

        }
        return false;

    }

}
